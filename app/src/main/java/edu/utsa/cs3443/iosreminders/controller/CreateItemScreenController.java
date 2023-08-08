package edu.utsa.cs3443.iosreminders.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import edu.utsa.cs3443.iosreminders.CreateActivity;

public class CreateItemScreenController implements View.OnClickListener {

        /*
         * Sets the OnClick method and takes in the view.
         * OnClick function makes all the avengers in a view.
         */
        @Override
        public void onClick(View view) {
            Context s = view.getContext();
            Context context = view.getContext();

            Intent intent = new Intent(context, CreateActivity.class);
            context.startActivity(intent);
        }
}