package com.werden.mycv.adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.werden.test.R
import com.werden.test.ui.activity.JsonScreen




class HomeAdapter(private var execises: ArrayList<String>, private val context: Context):  RecyclerView.Adapter<ViewHolderHome>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHome {
        return ViewHolderHome(
            LayoutInflater.from(context).inflate(
                R.layout.card_home,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return execises.size
    }

    override fun onBindViewHolder(holder: ViewHolderHome, position: Int) {
        holder.project.text = execises[position]
        holder.card.setOnClickListener{
            startActivity(execises[position])
        }
    }

    private fun startActivity(option: String){
        var intent: Intent = Intent()

        when(option){
            "Obstaculos" -> {

            }
            "JSON" -> {
                intent = Intent(context.applicationContext, JsonScreen::class.java)
                context.startActivity(intent)
            }
        }

        context.startActivity(intent)
        (context as Activity).finish()
    }

}

class ViewHolderHome (view: View): RecyclerView.ViewHolder(view){
    val project: TextView = view.findViewById(R.id.exercise_name)
    val card: CardView = view.findViewById(R.id.cardHome)
}