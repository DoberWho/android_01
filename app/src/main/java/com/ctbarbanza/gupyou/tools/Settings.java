package com.ctbarbanza.gupyou.tools;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.Serializable;


public class Settings {

    private SharedPreferences sharedPref;

    private Settings(Context ctx){
        sharedPref = ctx.getSharedPreferences("configuracion", Context.MODE_PRIVATE);
    }
    private static Settings instance;

    public static Settings init(Context ctx){
        if (instance == null){
            instance = new Settings(ctx);
        }
        return instance;
    }

    public void remove(String key){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.remove(key);
        editor.commit();
    }

    public void save(String key, String value){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getString(String key){
        return  sharedPref.getString(key,"");
    }

    public void save(String key, Float value){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    public Float getFloat(String key){
        float valorPorDefecto = 0;
        return  sharedPref.getFloat(key,valorPorDefecto);
    }


}
