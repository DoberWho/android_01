package com.ctbarbanza.gupyou.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.ctbarbanza.gupyou.R;
import com.ctbarbanza.gupyou.main.HomeFragment;
import com.ctbarbanza.gupyou.main.MainActivity;
import com.ctbarbanza.gupyou.main.MessageFragment;

public class AuthActivity extends AppCompatActivity {

    LoginFragment    frgLogin    = new LoginFragment();
    RegisterFragment frgRegister = new RegisterFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_auth);

        initView();
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
    }
}