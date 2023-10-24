package com.example.tugaspertemuan8fragmentlogin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatCheckBox
import com.example.tugaspertemuan8fragmentlogin.MainActivity.Companion.viewPagerCompanion
import com.example.tugaspertemuan8fragmentlogin.MainActivity.Companion.email
import com.example.tugaspertemuan8fragmentlogin.MainActivity.Companion.password
import com.example.tugaspertemuan8fragmentlogin.MainActivity.Companion.phone
import com.example.tugaspertemuan8fragmentlogin.MainActivity.Companion.username

class RegisterFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        with(view) {
//  inisialisasi elemen UI
            val textInputUsername = findViewById<EditText>(R.id.ETUsername)
            val textInputEmail = findViewById<EditText>(R.id.ETEMail)
            val textInputPhone = findViewById<EditText>(R.id.Phone)
            val textInputPassword = findViewById<EditText>(R.id.ETPassword)
            val checkBox = findViewById<AppCompatCheckBox>(R.id.appCompatCheckBox2)

            findViewById<View>(R.id.btnRegister).setOnClickListener {
                if (textInputUsername.text.toString().isEmpty()) {
                    textInputUsername.error = "Username Kosong"
                    return@setOnClickListener
                }
                if (textInputEmail.text.toString().isEmpty()) {
                    textInputEmail.error = "Email Kosong"
                    return@setOnClickListener
                }
                if (textInputPhone.text.toString().isEmpty()) {
                    textInputPhone.error = "Nomor Telepon Kosong"
                    return@setOnClickListener
                }
                if (textInputPassword.text.toString().isEmpty()) {
                    textInputPassword.error = "Password Kosong"
                    return@setOnClickListener
                }
                if (!checkBox.isChecked) {
                    Toast.makeText(context, "Silahkan menyetujui term & condition", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                username = textInputUsername.text.toString()
                email = textInputEmail.text.toString()
                phone = textInputPhone.text.toString()
                password = textInputPassword.text.toString()

                textInputUsername.text?.clear()
                textInputEmail.text?.clear()
                textInputPhone.text?.clear()
                textInputPassword.text?.clear()
                checkBox.isChecked = false

                viewPagerCompanion.currentItem = 1
            }

            findViewById<View>(R.id.linkLogin).setOnClickListener {
                viewPagerCompanion.currentItem = 1
            }
        }

        return view
    }
}
