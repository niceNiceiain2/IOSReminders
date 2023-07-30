package edu.utsa.cs3443.iosreminders.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import edu.utsa.cs3443.iosreminders.CreateActivity;
import edu.utsa.cs3443.iosreminders.MainActivity;

/*
 * Iain Summerlin - tea587
 *
 */
public class SigninController implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        Context context = view.getContext();
        int duration = Toast.LENGTH_SHORT;
        String username = MainActivity.username.getText().toString();
        String password = MainActivity.password.getText().toString();

        if (username.equals("iain")) {
            Toast toast = Toast.makeText(context,  username, duration);
            toast.show();

            Intent intent = new Intent(context, CreateActivity.class);
            intent.putExtra("username", username);
            context.startActivity(intent);
        }
        else {
            Toast toast = Toast.makeText(context, "Error wrong user " + username, duration);
            toast.show();
        }
    }
}

