package com.ricardo_rivera_beltran.sprintcuatro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private Button btnLogin, btnLoginReg;
    private EditText editEmailLogin, editPassLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLoginReg = (Button) findViewById(R.id.btnLoginReg);
        editEmailLogin = (EditText) findViewById(R.id.editEmailLogin);
        editPassLogin = (EditText) findViewById(R.id.editPassLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmailLogin.getText().toString();
                String pass = editPassLogin.getText().toString();

                FirebaseAuth mAuth;
                // ...
                // Initialize Firebase Auth
                mAuth = FirebaseAuth.getInstance();

                mAuth.signInWithEmailAndPassword(email, pass)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        Intent intent = new Intent(getApplicationContext(), Catalogo.class);
                                        startActivity(intent);
                                    }
                                });


            }
        });

        btnLoginReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Registro.class);
                startActivity(intent);

            }
        });
    }

}