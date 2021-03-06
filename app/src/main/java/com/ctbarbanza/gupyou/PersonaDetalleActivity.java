package com.ctbarbanza.gupyou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ctbarbanza.gupyou.models.Persona;

import agency.tango.android.avatarview.views.AvatarView;
import agency.tango.android.avatarviewglide.GlideLoader;

public class PersonaDetalleActivity extends AppCompatActivity {

    public static final String BUNDLE_PERSONA = "persona";

    private Persona persona;

    private TextView txtName, txtLastName, txtFacebook, txtGithub, txtGoogle;
    private AvatarView image;

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

        String url = persona.getImage();

        // TODO: Arreglar esto
        GlideLoader imageLoader = new GlideLoader();
        //imageLoader.loadImage(image, url, persona.getName());
    }

    private void initView(){
        txtName = findViewById(R.id.act_persona_detalle_name_txt);
        txtLastName = findViewById(R.id.act_persona_detalle_lastname_txt);

        txtFacebook = findViewById(R.id.act_persona_detalle_facebook_txt);
        txtGithub = findViewById(R.id.act_persona_detalle_github_txt);
        txtGoogle = findViewById(R.id.act_persona_detalle_google_txt);

        image = findViewById(R.id.act_persona_detalle_image);

    }
}