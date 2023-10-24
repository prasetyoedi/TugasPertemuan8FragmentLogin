package com.example.tugaspertemuan8fragmentlogin

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    private val page = mapOf<String, Fragment>(
        "register" to RegisterFragment(),
        "login" to LoginFragment()
    )

// metode yang mengembalikan jumlah tab yang akan ditampilkan
    override fun getItemCount(): Int = page.size

// metode yang digunakan untuk membuat fragment yang sesuai berdasarkan posisi tab
    override fun createFragment(position: Int): Fragment {
        return page.values.elementAt(position)
    }
}
