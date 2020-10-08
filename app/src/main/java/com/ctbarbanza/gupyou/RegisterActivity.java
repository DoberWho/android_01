package com.ctbarbanza.gupyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    private RegisterActivity ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        setContentView(R.layout.activity_register);

        Button btnLogin = findViewById(R.id.act_register_login_btn);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cuando Alguien Hace Click en el Boton
                Intent intent = new Intent(ctx, LoginActivity.class);
                startActivity(intent);
                ctx.onBackPressed();
            }
        });
    }
}