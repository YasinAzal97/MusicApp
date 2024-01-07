package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.db.viewModel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mUserViewModel: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val loginButton = findViewById<Button>(R.id.buttonLogin)

        loginButton.setOnClickListener {

            val emailEditText = findViewById<EditText>(R.id.editTextEmail_Reg).text.toString()
            val passwordEditText = findViewById<EditText>(R.id.editTextPassword).text.toString()

            val user = mUserViewModel.db.userDao().getUserByUsernameAndPassword(emailEditText,passwordEditText)


            if(user != null) {
                Toast.makeText(this, "erfolgreich eingeloggt", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SearchActivity::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Falsche Anmeldeinformationen", Toast.LENGTH_SHORT).show()
            }
        }
    }


    fun onClickPasswordForgot(view: View) {
        Toast.makeText(this, "Passwort vergessen", Toast.LENGTH_SHORT).show()
    }

    fun onClickTextView(view: View) {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
}
