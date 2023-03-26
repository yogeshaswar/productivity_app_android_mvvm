package com.yogeshaswar.productivitymvvm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yogeshaswar.productivitymvvm.adapters.TaskAdapter;
import com.yogeshaswar.productivitymvvm.models.Task;
import com.yogeshaswar.productivitymvvm.viewmodels.MAViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MAViewModel maViewModel;
    EditText edtTask, edtTime;
    Button btnAdd;
    RecyclerView recyclerView;
    List<Task> newTasksList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiateUI();
        newTasksList = new ArrayList<>();
        handleBtnClicks();
        maViewModel = new ViewModelProvider(this).get(MAViewModel.class);
        loadRecyclerView();

        // delete on swipe functionality
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Task task = newTasksList.get(viewHolder.getAdapterPosition());
                maViewModel.deleteTask(task);
                loadRecyclerView();
                Toast.makeText(MainActivity.this, "Task Deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);
    }

    private void loadRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        newTasksList = getAllTasks();
        recyclerView.setAdapter(new TaskAdapter(newTasksList));

    }

    private void handleBtnClicks() {
        btnAdd.setOnClickListener((v) -> {
            if((edtTask.getText().toString()).equals("")){
                Toast.makeText(this, "Task is empty", Toast.LENGTH_SHORT).show();
                return;
            }
            Task task = new Task(edtTask.getText().toString(), edtTime.getText().toString());
            addTaskToDB(task);
            loadRecyclerView();
        });
    }

    private void initiateUI() {
        edtTask = findViewById(R.id.et_task);
        edtTime = findViewById(R.id.et_expected_time);
        btnAdd = findViewById(R.id.btn_add_task);
        recyclerView = findViewById(R.id.recyclerview);
    }

    private void addTaskToDB(Task task) {
        maViewModel.addNewTask(task);
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        edtTask.setText("");
        edtTime.setText("");
    }

    private List<Task> getAllTasks() {
        List<Task> tasksList = maViewModel.getTasks();
        return tasksList;
    }
}