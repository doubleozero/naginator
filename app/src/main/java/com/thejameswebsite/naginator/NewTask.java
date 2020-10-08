package com.thejameswebsite.naginator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewTask extends AppCompatActivity {
    private EditText taskName;
    private Button createTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_task);

        createTask = findViewById(R.id.add_task);

        createTask.setOnClickListener((view) -> {

            taskName = findViewById(R.id.TaskName);
            String task = taskName.getText().toString().trim();
            // Toast.makeText(NewTask.this, task, Toast.LENGTH_SHORT).show(); // for debugging
            // take the name input and store it as a string

            Intent intent = getIntent();
            intent.putExtra("task_name", task);
            setResult(RESULT_OK, intent);
            // main activity's onActivityResult() is listening for a result
            finish(); // close this activity, returning to MainActivity
        });
    }
}