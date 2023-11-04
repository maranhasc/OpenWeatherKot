package net.azarquiel.weather.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.azarquiel.recyclerviewpajaros.adapter.CustomAdapter
import net.azarquiel.weather.R
import net.azarquiel.weather.model.Result
import java.net.URL


class MainActivity : AppCompatActivity() {
    private lateinit var adapter: CustomAdapter
    private lateinit var rvdia: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rvdia = findViewById<RecyclerView>(R.id.rvdia)
        initRV()
        getDatos()
    }

    private fun getDatos() {
        GlobalScope.launch() {
            val jsontxt = URL("https://api.openweathermap.org/data/2.5/forecast?q=Toledo,es&APPID=601c9db344b44f9774ef76a4c07979b1&lang=sp&units=metric").readText(Charsets.UTF_8)
            launch(Main) {
                val result = Gson().fromJson(jsontxt, Result::class.java)
                adapter.setDias(result.dias)
            }
        }
    }

    private fun initRV() {
        adapter = CustomAdapter(this, R.layout.rowdia)
        rvdia.adapter = adapter
        rvdia.layoutManager = LinearLayoutManager(this)
    }
}



