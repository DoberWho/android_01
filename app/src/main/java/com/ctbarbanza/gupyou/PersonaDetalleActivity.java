package com.ctbarbanza.gupyou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ctbarbanza.gupyou.models.Persona;

public class PersonaDetalleActivity extends AppCompatActivity {

    public static final String BUNDLE_PERSONA = "persona";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_persona_detalle);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            Persona persona = (Persona) extras.get(BUNDLE_PERSONA);
        }

    }
}