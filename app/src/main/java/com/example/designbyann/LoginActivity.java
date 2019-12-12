package com.example.designbyann;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.designbyann.DatabaseLogin.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {
    EditText User;
    EditText Pass;
    Button Login;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        User = (EditText) findViewById(R.id.edtUser);
        Pass = (EditText) findViewById(R.id.edtPass);
        Login = (Button) findViewById(R.id.signin);




        TextView signUp_text = findViewById(R.id.signUp_text);
        signUp_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(registerIntent);

            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = User.getText().toString();
                String pass = Pass.getText().toString();
                Boolean res = db.checkUser(user,pass);
                if(res == true)
                {
                    Intent it = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(it);
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Login Error",Toast.LENGTH_SHORT).show();
                }

            }
        });
        }


        }






