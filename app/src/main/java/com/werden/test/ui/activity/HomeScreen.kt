package com.werden.test.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.werden.mycv.adapters.HomeAdapter
import com.werden.test.R
import com.werden.test.interfaces.GeneralMethods
import kotlinx.android.synthetic.main.activity_home_screen.*

class HomeScreen : AppCompatActivity(), GeneralMethods {

    private var exercises = ArrayList<String>()
    private var adapter: HomeAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        exercises.add("Obstaculos")
        exercises.add("JSON")

        setRecycler()
    }

    override fun getData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setRecycler() {
        val lim = LinearLayoutManager(this)
        lim.orientation = LinearLayoutManager.VERTICAL
        recyclerHome.layoutManager = lim
        adapter = HomeAdapter(exercises,this@HomeScreen)
        recyclerHome.adapter = adapter
    }

}
