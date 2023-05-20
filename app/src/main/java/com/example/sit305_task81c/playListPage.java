package com.example.sit305_task81c;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class playListPage extends AppCompatActivity {
    TextView myList;

    ListView listItems;

    // We need to create a new list to get the array from previous page
    ArrayList<String> listData;

    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list_page);

        myList = findViewById(R.id.myListTextView);
        listItems = findViewById(R.id.mylistView);

        //get array and the intent from the previous activity using the key of the array
        listData = (ArrayList<String>) getIntent().getSerializableExtra("inputValue");

        // set a simple onItemClickListener, if user click an item on a specified position, the item should be deleted
        listItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // remove the item on the specified position using remove() method
                listData.remove(position);

                // after we remove the item, we refresh the listView to show the new array list
                refreshTheListView();
            }
        });

        refreshTheListView();
    }

    public void refreshTheListView(){
        // we use an arrayAdapter to fill data in the listView and set arrayAdapter to the listView
        aa = new ArrayAdapter<String>(playListPage.this, android.R.layout.simple_dropdown_item_1line, listData);
        listItems.setAdapter(aa);
    }
}