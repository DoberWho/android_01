package com.ctbarbanza.gupyou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {


    private LoginActivity ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        setContentView(R.layout.activity_login);

        Button btnRegistro = findViewById(R.id.act_login_register_btn);


        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cuando Alguien Hace Click en el Boton
                Intent intent = new Intent(ctx, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

}