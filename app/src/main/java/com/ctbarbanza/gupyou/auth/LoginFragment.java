package com.ctbarbanza.gupyou.auth;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ctbarbanza.gupyou.R;

import com.ctbarbanza.gupyou.models.Persona;
import com.ctbarbanza.gupyou.tools.Settings;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;


public class LoginFragment extends Fragment {


    private EditText edtEmail, edtPass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frg_login, container, false);
        intiViews(v);

        return v;
    }

    private void intiViews(View v) {
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
                comprobarFormulario(v);
            }
        });
        edtEmail = v.findViewById(R.id.frg_login_email_edt);
        edtPass = v.findViewById(R.id.frg_login_password_edt);
    }

    private void comprobarFormulario(View v) {
        String email = edtEmail.getText().toString().trim();
        String pass = edtPass.getText().toString().trim();

        if (email.isEmpty()){
            String errorMsg = getString(R.string.error_email_empty);
            edtEmail.setError(errorMsg);
            return;
        }
        if (pass.isEmpty()){
            String errorMsg = getString(R.string.error_pass_empty);
            edtPass.setError(errorMsg);
            return;
        }

        ((AuthActivity)getActivity()).login(email, pass);

    }

    private void goToMain() {
        Settings settings = Settings.init(getActivity());
        settings.save("user", "USER01");
        Persona per = new Persona(1);
        per.setLastName("Apellido");
        per.setGmail("GmailData");
        per.setFaceook("FacebookData");
        per.setGithub("GitHubData");

        settings.save("userData", per);

        ((AuthActivity)getActivity()).irAMain();
    }

    private void changeFragment() {
        // Avisar para cambiar al otro fragment
        ((AuthActivity)getActivity()).cambiarDeFragment(false);
    }
}