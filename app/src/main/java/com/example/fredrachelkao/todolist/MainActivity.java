package com.example.fredrachelkao.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.*;

import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<String>();
    }

    public void addToDo(View view) {
        String todo = ((EditText)findViewById(R.id.editText)).getText().toString();
        list.add(todo);
        ((EditText)findViewById(R.id.editText)).setText("");

        ListView listView = (ListView) findViewById(R.id.todo_list);

        if (adapter == null) {
            adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,
                    list);
            listView.setAdapter(adapter);
        } else {
            // update list adapter if list was already created previously
            adapter.notifyDataSetChanged();
        }

        Toast.makeText(MainActivity.this, "To-do added :) Long click to remove.", Toast.LENGTH_SHORT).show();

        // listen to clicks on the ListView
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                list.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

    }
}
