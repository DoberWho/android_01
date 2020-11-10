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
        Hawk.delete(key);
    }

    public void save(String key, Object value){
        Hawk.put(key, value);
    }

    private Object getObject(String key, Object defaultValue){
        if (!Hawk.contains(key)){
            return defaultValue;
        }
        return Hawk.get(key);
    }

    public Object getObject(String key){
        return this.getObject(key, null);
    }

    public String getString(String key){
        return (String) this.getObject(key, "");
    }

    public Float getFloat(String key){
        float valorPorDefecto = 0;
        return (Float) this.getObject(key, valorPorDefecto);
    }

    public boolean getBoolean(String key) {
        return (Boolean) this.getObject(key, false);
    }
}
