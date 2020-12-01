package com.ctbarbanza.gupyou.main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ctbarbanza.gupyou.R;

public class MainActivity extends AppCompatActivity {

    HomeFragment     frg01 = new HomeFragment();
    MessageFragment  frg02 = new MessageFragment();
    CommentFragment  frg03 = new CommentFragment();
    AlertFragment    frg04 = new AlertFragment();
    SettingsFragment frg05 = new SettingsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initButtons();
        initFragment();
        testLogs();
    }


    private void initButtons(){

        ImageButton btn01 = findViewById(R.id.imageButton);
        ImageButton btn02 = findViewById(R.id.imageButton2);
        ImageButton btn03 = findViewById(R.id.imageButton3);
        ImageButton btn04 = findViewById(R.id.imageButton4);
        ImageButton btn05 = findViewById(R.id.imageButton5);

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarFragment(frg01);
            }
        });
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarFragment(frg02);
            }
        });
        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarFragment(frg03);
            }
        });
        btn04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarFragment(frg04);
            }
        });
        btn05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarFragment(frg05);
            }
        });

    }

    private void initFragment() {
        cambiarFragment(this.frg01);
    }

    private void cambiarFragment(Fragment frg){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();

        trans.replace(R.id.act_main_container, frg, "fragment_01");

        trans.commit();
        Log.v("FRAGMENT", "He cambiado de Pantalla");
    }


    private void testLogs() {

        Log.v("VERBOSE", "Mensaje de Verbose");
        Log.d("DEBUG", "Mensjae de Debug");
        Log.i("INFO", "Mensaje de Info");
        Log.w("WARNING", "Mensaje de Warning");
        Log.e("ERROR", "Mensaje de Error");

        Log.wtf("WTF", "Gollum, Ese es mi anillo.");

    }
}