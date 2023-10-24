package com.example.tugaspertemuan8fragmentlogin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tugaspertemuan8fragmentlogin.MainActivity.Companion.password
import com.example.tugaspertemuan8fragmentlogin.MainActivity.Companion.username
import com.example.tugaspertemuan8fragmentlogin.MainActivity.Companion.viewPagerCompanion


class LoginFragment : Fragment() {
    private var textInputUsername: EditText? = null
    private var textInputPassword: EditText? = null
    private var loginButton: View? = null
    private var registerLink: TextView? = null
    private var forgetPasswordLink: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        textInputUsername = view.findViewById(R.id.ETUsername)
        textInputPassword = view.findViewById(R.id.ETPassword)
        loginButton = view.findViewById(R.id.btnLogin)
        registerLink = view.findViewById(R.id.linkregister)
        forgetPasswordLink = view.findViewById(R.id.linkforget)

        loginButton?.setOnClickListener {
            if (textInputUsername?.text.toString().isEmpty()) {
                Toast.makeText(context, "Masukkan username!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (textInputPassword?.text.toString().isEmpty()) {
                Toast.makeText(context, "Masukkan password!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (textInputUsername?.text.toString() != username || textInputPassword?.text.toString() != password) {
                Toast.makeText(context, "Username atau Password Salah", Toast.LENGTH_SHORT).show()
            } else {
                val intentToDashboardActivity = Intent(activity, DashboardActivity::class.java)
                startActivity(intentToDashboardActivity)
            }
        }

        registerLink?.setOnClickListener {
            viewPagerCompanion.currentItem = 0
        }

        forgetPasswordLink?.setOnClickListener {
            Toast.makeText(context, "", Toast.LENGTH_LONG).show()
        }

        return view
    }
}
