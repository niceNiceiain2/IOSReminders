package edu.utsa.cs3443.iosreminders.controller;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import edu.utsa.cs3443.iosreminders.EventPageActivity;

public class DeleteItemController implements View.OnClickListener {

    /*
     * Sets the OnClick method and takes in the view.
     * OnClick function makes all the avengers in a view.
     */
    @Override
    public void onClick(View view) {
        Context context = view.getContext();

        int n = EventPageActivity.itemSelected;
        EventPageActivity.user.removeEvent(n);

        Toast toast = Toast.makeText(context, "Event Deleted",Toast.LENGTH_SHORT);
        toast.show();

        Intent intent = new Intent(context, EventPageActivity.class);
        intent.putExtra("USER", EventPageActivity.user);
        context.startActivity(intent);
    }
}