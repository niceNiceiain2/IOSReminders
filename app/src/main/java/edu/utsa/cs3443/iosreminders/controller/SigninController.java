package edu.utsa.cs3443.iosreminders.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

import edu.utsa.cs3443.iosreminders.CreateActivity;
import edu.utsa.cs3443.iosreminders.MainActivity;
import edu.utsa.cs3443.iosreminders.model.User;

/*
 * Iain Summerlin - tea587
 *
 */
public class SigninController implements View.OnClickListener {
    HashMap<String, User> users = new HashMap(10);

    @Override
    public void onClick(View view) {
        Context context = view.getContext();
        InputStream inStream;
        int userID;
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
            userID = Integer.valueOf(st.nextToken()).intValue();
            String userNM = st.nextToken();
            String passWD = st.nextToken();
            User myuser = new User(userID, userNM, passWD);
            users.put(userNM,myuser);
        }

        try {
            inStream.close();
            inStream = am.open("accounts.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        scr = new Scanner(inStream);
        while (scr.hasNext()) {
            String line = scr.nextLine();
            StringTokenizer st = new StringTokenizer(line, ",");
            int uID = Integer.valueOf(st.nextToken()).intValue();
            String fullname = st.nextToken();
            String email = st.nextToken();
            for (HashMap.Entry<String, User> entry : users.entrySet()) {
                User user = entry.getValue();
                if (uID == user.getUserID()) {
                    user.setFullname(fullname);
                    user.setEmail(email);
                }
            }
        }

        if (authenticate(users.get(username),username, password)) {
            Intent intent = new Intent(context, CreateActivity.class);
            intent.putExtra("USER", users.get(username));
            context.startActivity(intent);
        }
        else {
            MainActivity.username.setError("Incorrect username and password combination.");
            MainActivity.password.setError("Incorrect username and password combination.");
        }
    }
    private boolean authenticate(User user, String username, String password) {
        if (user == null) {
            return false;
        }
        return username.equalsIgnoreCase(user.getUsername()) && password.equals(user.getPassword());
    }
}