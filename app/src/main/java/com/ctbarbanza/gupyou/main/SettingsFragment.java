package com.ctbarbanza.gupyou.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.ctbarbanza.gupyou.R;
import com.ctbarbanza.gupyou.auth.AuthActivity;
import com.ctbarbanza.gupyou.tools.Settings;

public class SettingsFragment extends Fragment {


    private Button btnLogout;
    private CheckBox check;

    // Editar Perfil de Usuario
    // Notificaciones On/Off
    // Cambiar Contraseña
    // Ver LegalTerms


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frg_settings, container, false);
        initViews(v);
        initListeners();
        updateData();
        return v;
    }

    private void updateData() {
        boolean isChecked = Settings.init(getActivity()).getBoolean("notifications");
        check.setChecked(isChecked);
    }

    private void initListeners() {
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doLogout();
            }
        });

        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                Log.d("Check", "Checked: "+isChecked);
                Settings.init(getActivity()).save("notifications", isChecked);
            }
        });
    }

    private void initViews(View v) {

        check = v.findViewById(R.id.frg_settting_notifications_check);
        btnLogout = v.findViewById(R.id.frg_settings_logout_btn);

    }

    private void doLogout() {
        Settings.init(getActivity()).remove("user");
        Intent intent = new Intent(getActivity(), AuthActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}