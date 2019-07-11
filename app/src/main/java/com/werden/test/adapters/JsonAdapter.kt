package com.werden.mycv.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.werden.test.R
import com.werden.test.models.JsonModel


class JsonAdapter(private var data: ArrayList<JsonModel>, private val context: Context):  RecyclerView.Adapter<ViewHolderJson>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderJson {
        return ViewHolderJson(
            LayoutInflater.from(context).inflate(
                R.layout.card_json,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolderJson, position: Int) {
        holder.title.text = data[position].title

        if (data[position].completed){
            holder.image_completed.background = context.getDrawable(R.drawable.circle_background_green)
            holder.image_completed.setImageResource(R.drawable.ic_check_white_24dp)
        }
        else {
            holder.image_completed.background = context.getDrawable(R.drawable.circle_background_pink)
            holder.image_completed.setImageResource(R.drawable.ic_close_white_24dp)
        }

    }

}

class ViewHolderJson (view: View): RecyclerView.ViewHolder(view){
    val title: TextView = view.findViewById(R.id.title)
    val image_completed: ImageView = view.findViewById(R.id.image_completed)
}