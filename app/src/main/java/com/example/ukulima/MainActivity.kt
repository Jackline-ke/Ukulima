package com.example.ukulima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //bottomNavigationBar
        bottomNavView.background = null
        bottomNavView.menu.getItem(1).isEnabled = false

        //navigationDrawer
        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)

        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view.setNavigationItemSelectedListener {

            when(it.itemId){
                R.id.navHome -> Toast.makeText(applicationContext, "Home", Toast.LENGTH_SHORT).show()
                R.id.navLocation -> Toast.makeText(applicationContext, "Location", Toast.LENGTH_SHORT).show()
                R.id.navMessage -> Toast.makeText(applicationContext, "Message", Toast.LENGTH_SHORT).show()
                R.id.navSetting -> Toast.makeText(applicationContext, "Setting", Toast.LENGTH_SHORT).show()
                R.id.navShare -> Toast.makeText(applicationContext, "Share", Toast.LENGTH_SHORT).show()
                R.id.navRecommendation -> Toast.makeText(applicationContext, "Review", Toast.LENGTH_SHORT).show()

            }
            true
        }

    }
    //for navigationDrawer
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}