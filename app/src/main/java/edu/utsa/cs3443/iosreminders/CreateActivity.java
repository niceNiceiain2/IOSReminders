package edu.utsa.cs3443.iosreminders;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.iosreminders.controller.CreateItemController;
import edu.utsa.cs3443.iosreminders.model.User;

public class CreateActivity extends AppCompatActivity {
    public static EditText descriptionField, dateField,nameField,timeField;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        Button submit = findViewById(R.id.SubmitButton);
        descriptionField=(EditText)findViewById(R.id.descriptionEntryField);
        dateField=(EditText)findViewById(R.id.DateField);
        nameField=(EditText)findViewById(R.id.NameField);
        timeField=(EditText)findViewById(R.id.TimeField);
        submit.setOnClickListener(new CreateItemController());
    }
}
