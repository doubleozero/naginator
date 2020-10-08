package com.thejameswebsite.naginator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    private TextView nagMsg;
    private Button newTask;
    private final int REQ_CODE = 1; // can be any number
    private TextView taskItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskItem = findViewById(R.id.task_item);

//        nagMsg = findViewById(R.id.nagMsg);
        // Display the top "nag" message

        newTask = findViewById(R.id.new_task_button);

        newTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // startActivity(new Intent(MainActivity.this, NewTask.class));
                // click "New Task" takes you to NewTask.java
                Intent intent = new Intent(MainActivity.this, NewTask.class);
                startActivityForResult(intent, REQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(MainActivity.this, "Debug Test", Toast.LENGTH_SHORT).show();

        if (requestCode == REQ_CODE) { // don't accept any code so not open to malicious attack
            assert data != null;
            String task = data.getStringExtra("task_name");
            taskItem.setText(task);
        } else {
            Toast.makeText(MainActivity.this, "Incorrect REQ_CODE",
                    Toast.LENGTH_SHORT).show();
        }


//    public void updateNagMsg(View v) {
//        String msgUpdate = "Oh look at you. You're trying to be productive.";
//        nagMsg.setText(msgUpdate);
//    }
    }
}
