package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.Benutzer
import com.example.myapplication.data.UserViewModel

class RegistrationActivity : AppCompatActivity() {

    private lateinit var mUserViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        val registrationButton = findViewById<Button>(R.id.buttonRegistration)

        registrationButton.setOnClickListener {

            val emailEditText = findViewById<EditText>(R.id.editTextEmail_Reg)
            val usernameEditText = findViewById<EditText>(R.id.textViewUsername_Reg)
            val passwordEditText = findViewById<EditText>(R.id.editTextPassword_Reg)

            val email = emailEditText.text.toString()
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            val newUser =
                Benutzer(email = email, password = password, username = username, benutzerID = null )

            mUserViewModel.db.userDao().insertBenutzer(newUser)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }

    fun onClickBackButton(view: View) {
        super.onBackPressedDispatcher.onBackPressed()
        }
}