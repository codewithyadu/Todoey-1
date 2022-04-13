package com.example.todoey.model.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoey.R
import com.example.todoey.model.data.task.Task
import kotlinx.android.synthetic.main.item_note.view.*

class PinnedTaskAdapter : RecyclerView.Adapter<PinnedTaskAdapter.ViewHolder>() {
    private var pinnedTaskList = emptyList<Task>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            // please try to use data binding
            LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = pinnedTaskList[position]
        val view = holder.itemView

        // move setting of this data inside view holder by making a new method inside view holder class
        // please use data binding 
        view.cv_item_task.setCardBackgroundColor(Color.parseColor(task.color))
        view.tv_title.text = task.title
        view.tv_body.text = task.body
    }

    override fun getItemCount(): Int {
        return pinnedTaskList.size
    }

    fun setData(tasks: List<Task>) {
        this.pinnedTaskList = tasks
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
