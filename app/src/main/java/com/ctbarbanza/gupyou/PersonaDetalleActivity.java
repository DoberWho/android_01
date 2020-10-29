package com.ctbarbanza.gupyou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.ctbarbanza.gupyou.models.Persona;

public class PersonaDetalleActivity extends AppCompatActivity {

    public static final String BUNDLE_PERSONA = "persona";

    private Persona persona;

    private TextView txtName, txtLastName, txtFacebook, txtGithub, txtGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_persona_detalle);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            persona = (Persona) extras.get(BUNDLE_PERSONA);
        }

        initView();
        updateData();

    }

    private void updateData() {
        txtName.setText(persona.getName());
        txtLastName.setText(persona.getLastName());
        txtFacebook.setText(persona.getFaceook());
        txtGithub.setText(persona.getGithub());
        txtGoogle.setText(persona.getGmail());
    }

    private void initView(){
        txtName = findViewById(R.id.act_persona_detalle_name_txt);
        txtLastName = findViewById(R.id.act_persona_detalle_name_txt);

        txtFacebook = findViewById(R.id.act_persona_detalle_name_txt);
        txtGithub = findViewById(R.id.act_persona_detalle_name_txt);
        txtGoogle = findViewById(R.id.act_persona_detalle_name_txt);

    }
}