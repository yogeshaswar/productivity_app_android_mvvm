package com.yogeshaswar.productivitymvvm.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.yogeshaswar.productivitymvvm.models.Task;

import java.util.List;

@Dao
public interface TaskDao {
    // methods
    @Insert
    void insertTask(Task task);
    @Delete
    void deleteTask(Task task);
    @Query("Select * FROM task_table")
    List<Task>getTasks();
    @Query("SELECT * FROM task_table WHERE task_column LIKE:taskName")
    List<Task>getSearchedTask(String taskName);
}
