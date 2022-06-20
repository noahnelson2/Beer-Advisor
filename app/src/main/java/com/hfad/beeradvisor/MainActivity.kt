package com.hfad.beeradvisor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    fun getBeers(color: String): List<String> {
        return when (color) {
            "Light" -> listOf("Jail Pale Ale", "Lager Lite")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
            else -> listOf("Gout Stout", "Dark Daniel")
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findBeer = findViewById<Button>(R.id.button)
        findBeer.setOnClickListener {
            val beerColor = findViewById<Spinner>(R.id.beer_color)
            val color = beerColor.selectedItem.toString()

            val beerList = getBeers(color.toString())
            val beers = beerList.reduce { str, item -> str + '\n' + item}
            val brands = findViewById<TextView>(R.id.brands)
            brands.text = beers
        }

    }
}