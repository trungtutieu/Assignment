package com.example.designbyann;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.designbyann.DatabaseLogin.DatabaseHelper;

public class RegistrationActivity extends AppCompatActivity {

    EditText User1;
    EditText Pass1;
    EditText CKPass1;
    Button Login1;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        db = new DatabaseHelper(this);
        User1 = (EditText) findViewById(R.id.edtUser1);
        Pass1 = (EditText) findViewById(R.id.edtPass1);
        CKPass1 = (EditText) findViewById(R.id.edtCKPass);
        Login1 = (Button) findViewById(R.id.btnLogin1);
        TextView signIn_text = findViewById(R.id.signIn_text);
        signIn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(LoginIntent);
            }
        });


        Login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = User1.getText().toString().trim();
                String pass = Pass1.getText().toString().trim();
                String ckpass = CKPass1.getText().toString().trim();

                if(pass.equals(ckpass)){
                    long val = db.addUser(user,pass);
                    if(val > 0){
                        Toast.makeText(RegistrationActivity.this,"You have registered",Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(RegistrationActivity.this,LoginActivity.class);
                        startActivity(moveToLogin);
                    }
                    else{
                        Toast.makeText(RegistrationActivity.this,"Registeration Error",Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(RegistrationActivity.this,"Password is not matching",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
