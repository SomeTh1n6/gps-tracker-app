package com.etwas.gpstracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.etwas.gpstracker.databinding.ActivityMainBinding
import com.etwas.gpstracker.fragments.MainFragment
import com.etwas.gpstracker.fragments.SettingsFragment
import com.etwas.gpstracker.fragments.TracksFragment
import com.etwas.gpstracker.utils.openFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onBottomNavClicks()
        openFragment(MainFragment.newInstance())
    }

    private fun onBottomNavClicks(){
        binding.bNan.setOnItemSelectedListener {
            when(it.itemId){
                R.id.id_home -> openFragment(MainFragment.newInstance())
                R.id.id_tracks -> openFragment(TracksFragment.newInstance())
                R.id.id_settings -> openFragment(SettingsFragment())
            }
            true
        }
    }
}