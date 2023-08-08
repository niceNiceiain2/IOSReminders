package edu.utsa.cs3443.iosreminders;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import edu.utsa.cs3443.iosreminders.controller.CreateItemController;
import edu.utsa.cs3443.iosreminders.controller.CreateItemScreenController;
import edu.utsa.cs3443.iosreminders.controller.DeleteItemController;
import edu.utsa.cs3443.iosreminders.model.Event;
import edu.utsa.cs3443.iosreminders.model.User;

/*
 * Iain Summerlin - tea587
 *
 *
 */
public class EventPageActivity extends AppCompatActivity {

    TableLayout tableLayout;
    public static int itemSelected;

    public static User user;

    @Override
    /*
     * Sets the OnCreate method and takes in the bundle and saved Instance state.
     * OnCreate function makes all the avengers in a button and returns the setOnClicker.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_page);

        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("USER");

        Button createitem = findViewById(R.id.button4);
        createitem.setOnClickListener(new CreateItemScreenController());

        Button deleteitem = findViewById(R.id.button3);
        deleteitem.setOnClickListener(new DeleteItemController());

        initializeTableLayout();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("USER");
        fillTable();
    }

    private void fillTable() {
        Integer count = 0;
        ArrayList<Event> eventList = user.getEventList();
        for (int i = 0; i < eventList.size(); i++) {

            TableRow tableRow = new TableRow(EventPageActivity.this);
            //if (count % 2 != 0) {
            //    tableRow.setBackgroundColor(Color.GRAY);
            //}
            tableRow.setId(View.generateViewId());
            tableRow.setClickable(true);
            tableRow.setBackgroundResource(android.R.drawable.list_selector_background);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT));

            TextView labelBarcode = new TextView(EventPageActivity.this);
            labelBarcode.setId(View.generateViewId());
            labelBarcode.setGravity(Gravity.CENTER);
            labelBarcode.setTextColor(Color.BLACK);
            labelBarcode.setTextSize(15);
            labelBarcode.setText(eventList.get(i).getName());
            tableRow.addView(labelBarcode);

            TextView labelLocation = new TextView(EventPageActivity.this);
            labelLocation.setId(View.generateViewId());
            labelLocation.setGravity(Gravity.CENTER);
            labelLocation.setTextColor(Color.BLACK);
            labelLocation.setTextSize(15);
            labelLocation.setText(eventList.get(i).getDescription());
            tableRow.addView(labelLocation);

            TextView labelQuantity = new TextView(EventPageActivity.this);
            labelQuantity.setId(View.generateViewId());
            labelQuantity.setGravity(Gravity.CENTER);
            labelQuantity.setTextColor(Color.BLACK);
            labelQuantity.setTextSize(15);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss");
            labelQuantity.setText(formatter.format(eventList.get(i).getTimeOfEvent()));
            tableRow.addView(labelQuantity);

            final int n = i;
            tableRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemSelected = n;
                    //Toast.makeText(MainPageActivity.this, "Click item " + n, Toast.LENGTH_SHORT).show();
                    v.setBackgroundColor(Color.YELLOW);
                }
            });

            tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            count++;
        }
    }

    private void initializeTableLayout() {
        tableLayout = this.findViewById(R.id.tableLayout);
        TableRow tr_head = new TableRow(EventPageActivity.this);
        tr_head.setId(View.generateViewId());
        tr_head.setBackgroundColor(Color.parseColor("#673AB7"));
        tr_head.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));

        TextView label_barcode = new TextView(EventPageActivity.this);
        label_barcode.setId(View.generateViewId());
        label_barcode.setText("Name");
        label_barcode.setTextSize(15);
        label_barcode.setTextColor(Color.WHITE);
        label_barcode.setGravity(Gravity.CENTER);
        tr_head.addView(label_barcode);// add the column to the table row here

        TextView label_location = new TextView(EventPageActivity.this);
        label_location.setId(View.generateViewId());// define id that must be         unique
        label_location.setText("Description"); // set the text for the header
        label_location.setTextSize(15);
        label_location.setTextColor(Color.WHITE); // set the color
        label_location.setGravity(Gravity.CENTER);
        tr_head.addView(label_location); // add the column to the table row here

        TextView label_quantity = new TextView(EventPageActivity.this);
        label_quantity.setId(View.generateViewId());// define id that must be         unique
        label_quantity.setText("Time"); // set the text for the header
        label_quantity.setTextSize(15);
        label_quantity.setTextColor(Color.WHITE); // set the color
        label_quantity.setGravity(Gravity.CENTER);
        tr_head.addView(label_quantity); // add the column to the table row here

        tableLayout.setScrollContainer(true);
        tableLayout.addView(tr_head, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
    }

}