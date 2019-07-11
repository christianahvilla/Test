package com.werden.test.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.werden.test.R
import kotlinx.android.synthetic.main.activity_obstacules.*

class Obstacle : AppCompatActivity() {

    private lateinit var array: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_obstacules)

        play.setOnClickListener {
            if (validate()){
                Toast.makeText(this@Obstacle, "Ingresa una cadena valida", Toast.LENGTH_SHORT).show()
            }
            else {
                play()
                play2()
            }
        }
    }


    private fun play2(){

        var up = 0
        var down = 0
        var position = 0

        array.forEach { s ->

            if (position < s.toInt()){
                up++
            }
            else{
                down++
            }

            position = s.toInt()

        }

        jump_down2.text = "Hacia abajo: $down"

        jump_up2.text = "Hacia arriba: $up"

    }

    private fun play(){

        var up = 0
        var down = 0
        var position = 0

        array.forEach { s ->

            if (position < s.toInt()){
                up += s.toInt() - position
            }
            else{
                down += position - s.toInt()
            }

            position = s.toInt()

        }

        jump_down.text = "Hacia abajo: $down"

        jump_up.text = "Hacia arriba: $up"

    }

    private fun validate(): Boolean{
        val myInput = input.text.toString()

        val regex = "^(([0-9]+)(\\s?[0-9]+)*)".toRegex()

        array = myInput.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        return array.isEmpty() && regex.matches(myInput)
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
