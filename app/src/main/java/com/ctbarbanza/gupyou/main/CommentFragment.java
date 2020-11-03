package com.ctbarbanza.gupyou.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

import com.ctbarbanza.gupyou.R;

public class CommentFragment extends Fragment {

    private SeekBar seekBar;
    private Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frg_comment, container, false);
        initViews(v);
        return v;
    }

    private void initViews(View v) {
        seekBar = v.findViewById(R.id.frg_comment_seekbar);
        spinner = v.findViewById(R.id.frg_comment_spinner);
    }
}