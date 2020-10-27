package com.ctbarbanza.gupyou.auth;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ctbarbanza.gupyou.R;


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
        ((AuthActivity)getActivity()).irAMain();
    }

    private void changeFragment() {
        // Avisar para cambiar al otro fragment
        ((AuthActivity)getActivity()).cambiarDeFragment(false);
    }
}