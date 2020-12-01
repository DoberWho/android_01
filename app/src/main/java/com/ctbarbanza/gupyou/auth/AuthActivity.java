package com.ctbarbanza.gupyou.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.FrameLayout;

import com.ctbarbanza.gupyou.R;
import com.ctbarbanza.gupyou.main.HomeFragment;
import com.ctbarbanza.gupyou.main.MainActivity;
import com.ctbarbanza.gupyou.main.MessageFragment;
import com.ctbarbanza.gupyou.tools.Settings;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.orhanobut.hawk.Hawk;

import java.util.Timer;

public class AuthActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    LoginFragment    frgLogin    = new LoginFragment();
    RegisterFragment frgRegister = new RegisterFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_auth);

        Hawk.init(this).build();
        mAuth = FirebaseAuth.getInstance();

        initView();
        checkLoging();
        goToAnother();
    }

    @Override
    public void onStart() {
        super.onStart();
        currentUser = mAuth.getCurrentUser();
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

    public void register(String email, String pass) {
        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            currentUser = mAuth.getCurrentUser();
                            String disp = currentUser.getDisplayName();
                            String email = currentUser.getEmail();
                            FirebaseUserMetadata meta = currentUser.getMetadata();
                            Uri photo = currentUser.getPhotoUrl();
                            String phone = currentUser.getPhoneNumber();
                            String uid = currentUser.getUid();
                            Log.d("USER", currentUser.getUid());
                            irAMain();
                        } else {
                            // If sign in fails, display a message to the user.
                             Exception ex = task.getException();
                             ex.printStackTrace();
                             String error = ex.getLocalizedMessage();
                            Snackbar.make(getCurrentFocus(), error, Snackbar.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void login(String email, String pass) {
        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            currentUser = mAuth.getCurrentUser();
                            String disp = currentUser.getDisplayName();
                            String email = currentUser.getEmail();
                            FirebaseUserMetadata meta = currentUser.getMetadata();
                            Uri photo = currentUser.getPhotoUrl();
                            String phone = currentUser.getPhoneNumber();
                            String uid = currentUser.getUid();
                            Log.d("USER", currentUser.getUid());
                            irAMain();
                        } else {
                            // If sign in fails, display a message to the user.
                            Exception ex = task.getException();
                            ex.printStackTrace();
                            String error = ex.getLocalizedMessage();
                            Snackbar.make(getCurrentFocus(), error, Snackbar.LENGTH_LONG).show();
                        }
                    }
                });
    }
}