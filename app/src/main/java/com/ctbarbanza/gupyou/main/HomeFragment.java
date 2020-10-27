package com.ctbarbanza.gupyou.main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ctbarbanza.gupyou.R;
import com.ctbarbanza.gupyou.adapter.PersonaAdapter;
import com.ctbarbanza.gupyou.adapter.listeners.PersonaAdapterListener;
import com.ctbarbanza.gupyou.models.Persona;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.frg_home, container, false);

        initButtons(v);
        initData(v);
        return v;
    }

    private void initButtons(View v) {
        Button btnAction = v.findViewById(R.id.frg_home_action_btn);
        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void initData(View v) {

        List<Persona> personas = new ArrayList<>();

        for (int idx = 0; idx < 10; idx++) {
            personas.add(new Persona(idx));
        }

        PersonaAdapterListener listener = new PersonaAdapterListener() {
            @Override
            public void click(Persona item, int position) {

            }
        };

        Activity ctx = getActivity();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(ctx);
        LinearLayoutManager manager = new LinearLayoutManager(ctx, LinearLayoutManager.HORIZONTAL, false);
        GridLayoutManager gridManager = new GridLayoutManager(ctx, 4);

        RecyclerView contenedor = v.findViewById(R.id.frg_home_container);
        contenedor.setLayoutManager(mLayoutManager);

        PersonaAdapter adaptador = new PersonaAdapter(ctx, personas, listener);
        contenedor.setAdapter(adaptador);
    }
}