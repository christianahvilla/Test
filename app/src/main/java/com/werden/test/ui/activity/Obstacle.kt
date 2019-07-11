package com.werden.test.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.werden.test.R
import kotlinx.android.synthetic.main.activity_obstacules.*

class Obstacle : AppCompatActivity() {

    private lateinit var array: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_obstacules)

        play.setOnClickListener {
            play()
        }
    }

    private fun play(){
        if (validate()){
            println("vacio")
        }
        else {
            println("lleno")
        }
    }

    private fun validate(): Boolean{
        val myInput = input.text.toString()
        array = myInput.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        return array.isEmpty()
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                val intent = Intent(this@Obstacle, HomeScreen::class.java)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@Obstacle, HomeScreen::class.java)
        startActivity(intent)
        finish()
    }
}
