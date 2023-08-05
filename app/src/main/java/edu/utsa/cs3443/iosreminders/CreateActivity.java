package edu.utsa.cs3443.iosreminders;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.iosreminders.controller.CreateItemController;

public class CreateActivity extends AppCompatActivity {
    public static EditText descriptionField, dateField,nameField,timeField;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        //TextView dateField = (TextView) findViewById(R.id.DateText);
        //TextView timeField = (TextView) findViewById(R.id.TimeText);
        //TextView NameField = (TextView) findViewById(R.id.NameText);
        //TextView descriptionField = (TextView) findViewById(R.id.DescriptionText);

        Button submit = findViewById(R.id.SubmitButton);
        descriptionField=(EditText)findViewById(R.id.descriptionEntryField);
        dateField=(EditText)findViewById(R.id.DateField);
        nameField=(EditText)findViewById(R.id.NameField);
        timeField=(EditText)findViewById(R.id.TimeField);
        submit.setOnClickListener(new CreateItemController());
    }
}
