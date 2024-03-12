package com.example.menu0;

import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import  android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.example_menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int i = item.getItemId();
        if(i==R.id.f1)
        {
            Toast.makeText(getApplicationContext(),"File 1 is selected",Toast.LENGTH_LONG).show();
        }
        else if(i==R.id.f2)
        {
            Toast.makeText(getApplicationContext(),"File 2 is selected",Toast.LENGTH_LONG).show();
        }
        else if(i==R.id.f3)
        {
            Toast.makeText(getApplicationContext(),"File 3 is selected",Toast.LENGTH_LONG).show();
        }
        return true;
    }
}
