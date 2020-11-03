package com.ctbarbanza.gupyou.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ctbarbanza.gupyou.R;
import com.ctbarbanza.gupyou.auth.AuthActivity;
import com.ctbarbanza.gupyou.tools.Settings;

public class SettingsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frg_settings, container, false);
        initViews(v);
        return v;
    }

    private void initViews(View v) {
        Button btn = v.findViewById(R.id.frg_settings_logout_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               doLogout();
            }
        });
    }

    private void doLogout() {
        Settings.init(getActivity()).remove("user");
        Intent intent = new Intent(getActivity(), AuthActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}