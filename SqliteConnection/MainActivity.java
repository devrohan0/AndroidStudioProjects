package com.example.sqliteexample;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MainActivity extends Activity {
    SQLiteDatabase db;
    TextView tv;
    EditText fname, lname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize all view objects
        tv = findViewById(R.id.textView1);
        fname = findViewById(R.id.editText1);
        lname = findViewById(R.id.editText2);

        // Create database if not already exist
        db = openOrCreateDatabase("Mydb", MODE_PRIVATE, null);

        // Create new table if not already exist
        db.execSQL("CREATE TABLE IF NOT EXISTS mytable(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, sur_name VARCHAR)");
    }

    // This method will be called when we click on insert button
    public void insert(View v) {
        String name = fname.getText().toString();
        String sur_name = lname.getText().toString();
        fname.setText("");
        lname.setText("");

        // Insert data into table
        db.execSQL("INSERT INTO mytable (name, sur_name) VALUES ('" + name + "','" + sur_name + "')");

        // Display Toast
        Toast.makeText(this, "Values inserted successfully.", Toast.LENGTH_LONG).show();
    }

    // This method will be called when we click on display button
    public void display(View v) {
        // Use cursor to retrieve all data
        Cursor c = db.rawQuery("SELECT * FROM mytable", null);
        tv.setText("");

        // Move cursor to first position
        if (c.moveToFirst()) {
            // Fetch and display all data one by one
            do {
                // Fetch data using column indices for name and sur_name
                String name = c.getString(c.getColumnIndex("name"));
                String surname = c.getString(c.getColumnIndex("sur_name"));

                // Display on text view
                tv.append("First Name: " + name + " & Last Name: " + surname + "\n");
            } while (c.moveToNext());
        } else {
            // Handle case when there is no data in the table
            Toast.makeText(this, "No data found in the table.", Toast.LENGTH_SHORT).show();
        }
        // Close cursor
        c.close();
    }
}
