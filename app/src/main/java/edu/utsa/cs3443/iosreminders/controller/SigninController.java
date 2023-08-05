package edu.utsa.cs3443.iosreminders.controller;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

import edu.utsa.cs3443.iosreminders.CreateActivity;
import edu.utsa.cs3443.iosreminders.MainActivity;

/*
 * Iain Summerlin - tea587
 *
 */
public class SigninController implements View.OnClickListener {
    String uname;
    String pass;

    @Override
    public void onClick(View view) {
        Context context = view.getContext();
        InputStream inStream;
        String username = MainActivity.username.getText().toString();
        String password = MainActivity.password.getText().toString();

        AssetManager am = context.getAssets();
        try {
            inStream = am.open("login.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scanner scr = new Scanner(inStream);
        while (scr.hasNext()) {
            String line = scr.nextLine();
            StringTokenizer st = new StringTokenizer(line, ",");
            uname = st.nextToken();
            pass = st.nextToken();
        }

        if (authenticate(username, password)) {
            Intent intent = new Intent(context, CreateActivity.class);
            context.startActivity(intent);
        }
        else {
            MainActivity.username.setError("Incorrect username and password combination.");
            MainActivity.password.setError("Incorrect username and password combination.");
        }
    }
    private boolean authenticate(String username, String password) {
        return username.equalsIgnoreCase(uname) && password.equals(pass);
    }
}

