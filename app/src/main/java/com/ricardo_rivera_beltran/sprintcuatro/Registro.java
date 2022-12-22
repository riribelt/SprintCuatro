package com.ricardo_rivera_beltran.sprintcuatro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Registro extends AppCompatActivity {

    private Button btnRegister;
    private EditText editEmailReg, editPassReg, editConfirmPassReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        editEmailReg = (EditText) findViewById(R.id.editEmailReg);
        editPassReg = (EditText) findViewById(R.id.editPassReg);
        editConfirmPassReg = (EditText) findViewById(R.id.editConfirmPassReg);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmailReg.getText().toString();
                String pass = editPassReg.getText().toString();
                String confirm = editConfirmPassReg.getText().toString();

                if (pass.compareTo(confirm) == 0){
                    FirebaseAuth mAuth;
                    // ...
                    // Initialize Firebase Auth
                    mAuth = FirebaseAuth.getInstance();
                    mAuth.createUserWithEmailAndPassword(email, pass);
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Registro.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}