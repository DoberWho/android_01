package com.ctbarbanza.gupyou.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;

import com.ctbarbanza.gupyou.R;
import com.ctbarbanza.gupyou.adapter.RasgosAdapter;
import com.ctbarbanza.gupyou.models.Rasgo;

import java.util.ArrayList;
import java.util.List;

public class CommentFragment extends Fragment {

    private SeekBar seekBar;
    private Spinner spinner;

    private Rasgo currentRasgo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frg_comment, container, false);
        initViews(v);
        updateData();
        return v;
    }


    private void initViews(View v) {
        seekBar = v.findViewById(R.id.frg_comment_seekbar);
        spinner = v.findViewById(R.id.frg_comment_spinner);
    }

    private void updateData() {
        ArrayList<Rasgo> rasgos = new ArrayList<Rasgo>();
        Rasgo rasgo = new Rasgo();
        rasgo.value = "Higiene";
        rasgos.add(rasgo);
         rasgo = new Rasgo();
        rasgo.value = "Dinero";
        rasgos.add(rasgo);
         rasgo = new Rasgo();
        rasgo.value = "Carisma";
        rasgos.add(rasgo);
         rasgo = new Rasgo();
        rasgo.value = "Elocuencia";
        rasgos.add(rasgo);
        rasgo = new Rasgo();
        rasgo.value = "Social";
        rasgos.add(rasgo);
        rasgo = new Rasgo();
        rasgo.value = "Responsable";
        rasgos.add(rasgo);

        List items = new ArrayList<String>();
        // LAMBDA : Para cada elemento de rasgos hace 1 acción
        rasgos.forEach(rasgo1 -> items.add(rasgo1.value));

        RasgosAdapter resgoAdapter = new RasgosAdapter(getActivity(), rasgos);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, items);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("RASGO", "Posicion:"+i);
                currentRasgo = rasgos.get(i);
                Log.i("RASGO", "Rasgo:"+currentRasgo.toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Salta cuando no se pulsa nada o cuando se pulsa la misma que estaba seleccionada.
            }
        });

    }
}