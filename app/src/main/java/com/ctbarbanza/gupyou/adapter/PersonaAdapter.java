package com.ctbarbanza.gupyou.adapter;

import android.app.Activity;
import android.app.Person;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ctbarbanza.gupyou.R;
import com.ctbarbanza.gupyou.adapter.listeners.PersonaAdapterListener;
import com.ctbarbanza.gupyou.models.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaAdapter.PersonaHolder> {

    private static final int layout = R.layout.persona_adapter_item;
    private final PersonaAdapterListener listener;
    private final Activity act;
    private List<Persona> items = new ArrayList<Persona>();

    public PersonaAdapter(Activity act, List<Persona> items, PersonaAdapterListener listener) {
        this.act = act;
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PersonaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(layout, parent, false);

        return new PersonaHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaHolder holder, int position) {
        final Persona item = items.get(position);

        String texto = item.getName();
        holder.txt.setText(texto);

        holder.linRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (listener != null) {
                    listener.click(item, position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class PersonaHolder extends RecyclerView.ViewHolder {
        public TextView txt;
        public ImageView icon;

        public ConstraintLayout linRoot;

        void initView(View v){
            txt = v.findViewById(R.id.persona_adapter_item_name);
            icon = v.findViewById(R.id.persona_adapter_item_image);
            linRoot = v.findViewById(R.id.persona_adapter_root);
        }

        public PersonaHolder(View v) {
            super(v);
            initView(v);
        }
    }
}