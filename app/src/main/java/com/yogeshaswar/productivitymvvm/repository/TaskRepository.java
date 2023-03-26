package com.yogeshaswar.productivitymvvm.repository;

import android.app.Application;

import com.yogeshaswar.productivitymvvm.db.AppDatabase;
import com.yogeshaswar.productivitymvvm.db.TaskDao;
import com.yogeshaswar.productivitymvvm.models.Task;

import java.util.List;

public class TaskRepository {
    Application application;
    TaskDao taskDao;
    List<Task> tasks;
    List<Task> searchedTask;
    public TaskRepository(Application application) {
        this.application = application;
        AppDatabase appDatabase = AppDatabase.getAppDatabase(application);
        taskDao = appDatabase.taskDao();
    }
    // methods
    public void addTask(Task task){
        taskDao.insertTask(task);
    }
    public void deleteTask(Task task){
        taskDao.deleteTask(task);
    }
    public List<Task> getTasks(){
        tasks = taskDao.getTasks();
        return tasks;
    }
    public List<Task>getSearchedTask(String taskName){
        searchedTask = taskDao.getSearchedTask(taskName);
        return searchedTask;
    }

}
