package org.mahnoorabid.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> friendArraylist;
    EditText editText;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.edit_query);
        Button button=findViewById(R.id.bTnAdd);
        editText = findViewById(R.id.editTextAdd);
        String [] friendlist={"Mahnoor","Shiza","Fatima","Aqsa","Zari"};
         friendArraylist=new ArrayList<String>();
        friendArraylist.add("Mahnoor");
        friendArraylist.add("Hina");
        friendArraylist.add("Fizza");
        friendArraylist.add("Shiza");

         arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                friendlist);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Log.d("You clicked",friendArraylist.get(i));

            }
        });
    }

    public void AddFriend(View view) {
friendArraylist.add(editText.getText().toString());
arrayAdapter.notifyDataSetChanged();
        Collections.sort(friendArraylist);
    }
}