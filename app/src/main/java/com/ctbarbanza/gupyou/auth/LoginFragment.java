package com.ctbarbanza.gupyou.auth;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ctbarbanza.gupyou.R;

import com.ctbarbanza.gupyou.models.Persona;
import com.ctbarbanza.gupyou.tools.Settings;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;


public class LoginFragment extends Fragment {

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frg_login, container, false);
        Button btn = v.findViewById(R.id.frg_login_register_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment();
            }
        });

        Button btnAction = v.findViewById(R.id.frg_login_action_btn);
        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMain();
            }
        });

        return v;
    }

    private void goToMain() {
        Settings settings = Settings.init(getActivity());
        settings.save("user", "USER01");
        Persona per = new Persona(1);
        per.setLastName("Apellido");
        per.setGmail("GmailData");
        per.setFaceook("FacebookData");
        per.setGithub("GitHubData");

        String serializedObject = "";
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream so = new ObjectOutputStream(bo);
            so.writeObject(per);
            so.flush();
            serializedObject = bo.toString();
        } catch (Exception e) {
            System.out.println(e);
        }

        settings.save("userData", serializedObject);

        ((AuthActivity)getActivity()).irAMain();
    }

    private void changeFragment() {
        // Avisar para cambiar al otro fragment
        ((AuthActivity)getActivity()).cambiarDeFragment(false);
    }
}