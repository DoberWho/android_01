package com.ctbarbanza.gupyou.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.FrameLayout;

import com.ctbarbanza.gupyou.R;
import com.ctbarbanza.gupyou.main.HomeFragment;
import com.ctbarbanza.gupyou.main.MainActivity;
import com.ctbarbanza.gupyou.main.MessageFragment;
import com.ctbarbanza.gupyou.tools.Settings;
import com.orhanobut.hawk.Hawk;

import java.util.Timer;

public class AuthActivity extends AppCompatActivity {

    LoginFragment    frgLogin    = new LoginFragment();
    RegisterFragment frgRegister = new RegisterFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_auth);

        Hawk.init(this).build();

        initView();
        checkLoging();
        goToAnother();
    }

    private void goToAnother() {

        Handler handler = new Handler();
        Runnable runnable;
        handler.postDelayed(runnable = new Runnable() {
            public void run() {
                //irAMain();
            }
        }, 1000);


    }

    private void checkLoging() {
        String user = Settings.init(this).getString("user");
        if (user != null && !user.isEmpty()){
            irAMain();
        }
    }

    private void initView() {
        changeFragment(frgLogin);
    }

    private void changeFragment(Fragment frg){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();

        trans.replace(R.id.act_auth_container_frame, frg, "fragment_01");

        trans.commit();
    }

    /**
     *
     * @param isLogin <strong>TRUE</strong> para login, <strong>FALSE</strong> para registro
     */
    public void cambiarDeFragment(boolean isLogin) {
        if (isLogin){
            changeFragment(frgLogin);
        }else{
            changeFragment(frgRegister);
        }
    }

    public void irAMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}