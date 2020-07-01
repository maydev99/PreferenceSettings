package com.bombadu.preferencesettings

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.settings -> {
                startActivity(Intent(this, SettingsActivity::class.java))
            }
        }


        return super.onOptionsItemSelected(item)


    }

    override fun onStart() {
        super.onStart()

        val myEditText = findViewById<EditText>(R.id.myEditText)

        val sharedPreferences: SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(this)
        val redText = sharedPreferences.getBoolean("red_text", false)
        val largeText = sharedPreferences.getBoolean("large_text", false)
        val boldText = sharedPreferences.getBoolean("bold_text", false)


        when {
            redText -> {
                myEditText.setTextColor(Color.RED)
            }
            else -> {
                myEditText.setTextColor(Color.BLACK)
            }
        }

        when {
            largeText -> {
                myEditText.textSize = 28f
            }
            else -> {
                myEditText.textSize = 16f
            }
        }

        when {
            boldText -> {
                myEditText.setTypeface(null, Typeface.BOLD)
            }
            else -> {
                myEditText.setTypeface(null, Typeface.NORMAL)
            }
        }



    }
}