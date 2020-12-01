package com.ctbarbanza.gupyou.auth;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ctbarbanza.gupyou.R;
import com.ctbarbanza.gupyou.tools.Settings;
import com.google.android.material.snackbar.Snackbar;

public class RegisterFragment extends Fragment {

    private EditText edtEmail, edtPass, edtConfirm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.frg_register, container, false);
        initView(v);

        return v;
    }

    private void initView(View v) {
        Button btn = v.findViewById(R.id.frg_register_login_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment();
            }
        });

        Button btnAction = v.findViewById(R.id.frg_register_action_btn);
        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprobarFormulario(v);
            }
        });

        edtEmail = v.findViewById(R.id.frg_register_email_edt);
        edtPass = v.findViewById(R.id.frg_register_password_edt);
        edtConfirm = v.findViewById(R.id.frg_register_password_confirm_edt);
    }


    private void comprobarFormulario(View v) {
        String email = edtEmail.getText().toString().trim();
        String pass = edtPass.getText().toString().trim();
        String confirm = edtConfirm.getText().toString().trim();

        if (email.isEmpty() || pass.isEmpty() || confirm.isEmpty()){
            if (email.isEmpty()){
                String errorMsg = getString(R.string.error_email_empty);
                edtEmail.setError(errorMsg);
            }
            if (pass.isEmpty()){
                String errorMsg = getString(R.string.error_pass_empty);
                edtPass.setError(errorMsg);
            }
            if (confirm.isEmpty()){
                String errorMsg = getString(R.string.error_confirm_empty);
                edtConfirm.setError(errorMsg);
            }
            String errorMsg = getString(R.string.error_registro_formulario);
            Snackbar snack = Snackbar.make(v, errorMsg, Snackbar.LENGTH_LONG);
            snack.show();
            return;
        }
        if (!pass.equals(confirm)){
            return;
        }



    }

    private void goToMain() {
        Settings.init( getActivity() ).save("user", "USER01");
        ((AuthActivity)getActivity()).irAMain();
    }

    private void changeFragment() {
        // Avisar para cambiar al otro fragment
        ((AuthActivity)getActivity()).cambiarDeFragment(true);
    }
}