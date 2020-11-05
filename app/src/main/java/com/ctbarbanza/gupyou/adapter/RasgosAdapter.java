package com.ctbarbanza.gupyou.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ctbarbanza.gupyou.R;
import com.ctbarbanza.gupyou.models.Rasgo;

import java.util.ArrayList;

public class RasgosAdapter extends ArrayAdapter<Rasgo> {

    private static final int LAYOUT = R.layout.rasgo_adapter_item;

    public RasgosAdapter(Context context, ArrayList<Rasgo> users) {
       super(context, LAYOUT, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       if (convertView == null) {
          convertView = LayoutInflater.from(getContext()).inflate(LAYOUT, parent, false);
       }

       TextView txtName = (TextView) convertView.findViewById(R.id.rasgo_adapter_item_text);
       Rasgo rasgo = getItem(position);
       txtName.setText(rasgo.value);

       return convertView;
   }
}