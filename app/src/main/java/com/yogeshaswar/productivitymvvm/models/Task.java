package com.yogeshaswar.productivitymvvm.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_table")
public class Task {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "task_column")
    String task;
    @ColumnInfo(name = "time")
    String expectedTime;

    public Task(int id, String task, String expectedTime) {
        this.id = id;
        this.task = task;
        this.expectedTime = expectedTime;
    }
    @Ignore
    public Task(String task, String expectedTime) {
        this.task = task;
        this.expectedTime = expectedTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(String expectedTime) {
        this.expectedTime = expectedTime;
    }
}
