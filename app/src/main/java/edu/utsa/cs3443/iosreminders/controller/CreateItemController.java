package edu.utsa.cs3443.iosreminders.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import edu.utsa.cs3443.iosreminders.CreateActivity;
import edu.utsa.cs3443.iosreminders.EventPageActivity;
import edu.utsa.cs3443.iosreminders.model.Event;

public class CreateItemController implements View.OnClickListener {

    /*
     * Sets the OnClick method and takes in the view.
     * OnClick function makes all the avengers in a view.
     */
    @Override
    public void onClick(View view) {
        Context context = view.getContext();
        String name = CreateActivity.nameField.getText().toString();
        String time = CreateActivity.timeField.getText().toString();
        String date = CreateActivity.dateField.getText().toString();
        String description = CreateActivity.descriptionField.getText().toString();

        //@TODO Create event here
        LocalDateTime createdTime = LocalDateTime.now();
        // Have enter date: 2023-08-10 and time as 11:30:00
        // format is        YYYY-MM-DD             HH:MM:SS
        LocalDateTime eventTime = LocalDateTime.parse(date + "T" + time);
        Event newEvent = new Event(1, name, description, createdTime, eventTime, null, null);
        EventPageActivity.user.addEvent(newEvent);

        Intent intent = new Intent(context, EventPageActivity.class);
        intent.putExtra("USER", EventPageActivity.user);
        context.startActivity(intent);
    }
}
