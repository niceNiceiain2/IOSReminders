package edu.utsa.cs3443.iosreminders;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


/*
 * Iain Summerlin - tea587
 *
 * The Main Activity class extends AppCompatActivity.
 *
 */
public class MainActivity extends AppCompatActivity {

    public static EditText username, password;

    @Override
    /*
     * Sets the OnCreate method and takes in the bundle and saved Instance state.
     * OnCreate function makes all the avengers in a button and returns the setOnClicker.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
    }
}