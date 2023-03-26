package com.yogeshaswar.productivitymvvm.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.yogeshaswar.productivitymvvm.models.Task;
import com.yogeshaswar.productivitymvvm.repository.TaskRepository;

import java.util.List;

public class MAViewModel extends AndroidViewModel {
    TaskRepository taskRepository;
    List<Task> tasks;
    List<Task> searchedTask;
    public MAViewModel(@NonNull Application application) {
        super(application);
        // repository
        taskRepository = new TaskRepository(application);

    }
    // methods
    public void addNewTask(Task task){
        taskRepository.addTask(task);
    }
    public void deleteTask(Task task){
        taskRepository.deleteTask(task);
    }
    public List<Task>getTasks(){
        tasks = taskRepository.getTasks();
        return tasks;
    }
    public List<Task>getSearchedTask(String taskName){
        searchedTask = taskRepository.getSearchedTask(taskName);
        return  searchedTask;
    }

}
