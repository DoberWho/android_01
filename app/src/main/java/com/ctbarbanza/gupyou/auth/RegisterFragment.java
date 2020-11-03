package com.ctbarbanza.gupyou.auth;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ctbarbanza.gupyou.R;
import com.ctbarbanza.gupyou.tools.Settings;

public class RegisterFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.frg_register, container, false);
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
                goToMain();
            }
        });

        return v;
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