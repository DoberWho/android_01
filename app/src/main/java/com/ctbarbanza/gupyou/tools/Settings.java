package com.ctbarbanza.gupyou.tools;

import android.content.Context;
import android.content.SharedPreferences;

import com.orhanobut.hawk.Hawk;

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

    public void save(String key, Object value){
        Hawk.put(key, value);
    }

    public String getString(String key){
        if (!Hawk.contains(key)){
            return "";
        }
        return Hawk.get(key);
    }

    public Float getFloat(String key){
        float valorPorDefecto = 0;
        if (!Hawk.contains(key)){
            return valorPorDefecto;
        }
        return Hawk.get(key);
    }

    public Object getObject(String key){
        if (!Hawk.contains(key)){
            return null;
        }
        return Hawk.get(key);
    }


}
