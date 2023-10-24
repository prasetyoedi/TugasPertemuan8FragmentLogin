package com.example.tugaspertemuan8fragmentlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.tugaspertemuan8fragmentlogin.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager2 = binding.viewpager
        viewPager2.adapter = TabAdapter(this@MainActivity)

        TabLayoutMediator(binding.tablayout, viewPager2) { tab, position ->
            tab.text = when(position) {
                0 -> "Register" // Teks untuk tab pertama
                1 -> "Login"    // Teks untuk tab kedua
                else -> ""       // Tidak ada teks untuk posisi lainnya
            }
        }.attach()

        viewPagerCompanion = viewPager2
    }

    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
        const val EXTRA_PASSWORD = "extra_password"

        var username: String = ""
        var email: String = ""
        var phone: String = ""
        var password: String = ""

        lateinit var viewPagerCompanion: ViewPager2
    }
}
