package edu.utsa.cs3443.iosreminders.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import edu.utsa.cs3443.iosreminders.CreateActivity;

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
        //Event newEvent = new Event(name, time, date, description);

        Intent intent = new Intent(context, CreateActivity.class);
        context.startActivity(intent);
    }
}
