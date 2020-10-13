package com.ctbarbanza.gupyou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;


import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        Button btnRegistro = findViewById(R.id.act_login_register_btn);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cuando Alguien Hace Click en el Boton
                cambiarARegistro();
            }
        });

        Button btnLogin = findViewById(R.id.act_login_action_btn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {










            }
        });

    }

    private void doLogin(){
        EditText edtEmail = findViewById(R.id.act_login_email_edt);
        EditText edtPass = findViewById(R.id.act_login_password_edt);
        CheckBox chkRemember = findViewById(R.id.act_login_remember_chk);

        String email = edtEmail.getText().toString();
        String pass  = edtPass.getText().toString();

        boolean isChecked = chkRemember.isChecked();

        boolean check = true; // TODO: Comprobar que los datos están bien
        if (check){
            // Login - OK
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            // Login - KO
        }

    }

    private void cambiarARegistro(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

}