package com.yogeshaswar.productivitymvvm.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yogeshaswar.productivitymvvm.R;
import com.yogeshaswar.productivitymvvm.models.Task;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewModel> {
    List<Task> tasks;

    public TaskAdapter(List<Task> tasks) {
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public TaskViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View taskView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item_card, parent, false);
        return new TaskViewModel(taskView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewModel holder, int position) {
        holder.tvTask.setText(tasks.get(position).getTask());
        holder.tvTime.setText(tasks.get(position).getExpectedTime());
    }

    @Override
    public int getItemCount() {
        if(!(tasks.isEmpty())){
            return tasks.size();
        } else {
            return 0;
        }
    }

    public class TaskViewModel extends RecyclerView.ViewHolder{
        TextView tvTask, tvTime;
        public TaskViewModel(@NonNull View itemView) {
            super(itemView);
            tvTask = itemView.findViewById(R.id.tv_show_task);
            tvTime = itemView.findViewById(R.id.tv_show_time);
        }
    }

}
