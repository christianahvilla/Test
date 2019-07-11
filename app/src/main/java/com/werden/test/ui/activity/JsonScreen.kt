package com.werden.test.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.google.gson.Gson
import com.werden.mycv.adapters.JsonAdapter
import com.werden.test.R
import com.werden.test.api.Controller
import com.werden.test.api.ServiceVolley
import com.werden.test.interfaces.GeneralMethods
import com.werden.test.models.JsonModel
import kotlinx.android.synthetic.main.activity_json.*
import com.google.gson.reflect.TypeToken


class JsonScreen : AppCompatActivity(), GeneralMethods {

    private val serviceVolley = ServiceVolley()
    private val controller = Controller(serviceVolley)
    private var data: ArrayList<JsonModel> = ArrayList()
    private var adapter: JsonAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json)

        getData()

        swipeRefresh.setOnRefreshListener {
            getData()
        }

    }

    override fun getData() {
        val path = resources.getString(R.string.base_path)

        swipeRefresh.isRefreshing = true

        controller.get(path) { response ->

            val jsonOutput = response.toString()
            val listType = object : TypeToken<ArrayList<JsonModel>>() {

            }.type
            data = Gson().fromJson(jsonOutput, listType)

            swipeRefresh.isRefreshing = false

            setRecycler()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                val intent = Intent(this@JsonScreen, HomeScreen::class.java)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@JsonScreen, HomeScreen::class.java)
        startActivity(intent)
        finish()
    }


    override fun setRecycler() {
        val lim = LinearLayoutManager(this)
        lim.orientation = LinearLayoutManager.VERTICAL
        recyclerJSON.layoutManager = lim
        adapter = JsonAdapter(data,this@JsonScreen)
        recyclerJSON.adapter = adapter
    }
}
