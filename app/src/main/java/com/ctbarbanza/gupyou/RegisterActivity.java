package com.ctbarbanza.gupyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class RegisterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initButtons();
    }

    private void initButtons(){
        Button btnLogin = findViewById(R.id.act_register_login_btn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cuando Alguien Hace Click en el Boton
                doCambiarLogin();
            }
        });

        Button btnAction = findViewById(R.id.act_register_action_btn);
        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cuando Alguien Hace Click en el Boton
                doRegistro();
            }
        });

        ImageButton btnFacebook = findViewById(R.id.act_register_facebook_btn);
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doLoginFacebook();
            }
        });
        ImageButton btnGithub = findViewById(R.id.act_register_github_btn);
        btnGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doLoginGithub();
            }
        });
        ImageButton btnGoogle = findViewById(R.id.act_register_google_btn);
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doLoginGoogle();
            }
        });
        
    }

    private void doLoginGoogle() {
    }

    private void doLoginGithub() {
    }

    private void doLoginFacebook() {
    }

    private void doRegistro() {
        EditText edtEmail = findViewById(R.id.act_register_email_edt);
        EditText edtPass  = findViewById(R.id.act_register_password_edt);
        EditText edtPassConfirm = findViewById(R.id.act_register_password_confirm_edt);

        String email = edtEmail.getText().toString();
        String pass  = edtPass.getText().toString();
        String passConfirm  = edtPassConfirm.getText().toString();

        boolean check = (pass.equals(passConfirm)); // TODO: Comprobar que los datos están bien
        if (check){
            // Login - OK
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            // Login - KO
        }
    }

    private void doCambiarLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        onBackPressed();
    }
}