package com.ctbarbanza.gupyou.main;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ctbarbanza.gupyou.R;
import com.ctbarbanza.gupyou.auth.AuthActivity;
import com.ctbarbanza.gupyou.tools.Settings;

public class SettingsFragment extends Fragment {


    private Button btnLogout, btnOthers, btnLegal, btnChangePass;
    private CheckBox check;

    private  AlertDialog dialog;

    // Editar Perfil de Usuario
    // Notificaciones On/Off
    // Cambiar Contraseña
    // Ver LegalTerms


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frg_settings, container, false);
        initViews(v);
        initListeners();
        updateData();
        return v;
    }

    private void updateData() {
        boolean isChecked = Settings.init(getActivity()).getBoolean("notifications");
        check.setChecked(isChecked);
    }

    private void initListeners() {
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doLogout();
            }
        });
        btnOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });

        btnLegal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogLegal();
            }
        });

        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogEditable();
            }
        });

        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                Log.d("Check", "Checked: "+isChecked);
                Settings.init(getActivity()).save("notifications", isChecked);
            }
        });
    }

    private void initViews(View v) {

        check = v.findViewById(R.id.frg_settting_notifications_check);
        btnLogout = v.findViewById(R.id.frg_settings_logout_btn);
        btnOthers = v.findViewById(R.id.frg_settings_others_btn);
        btnLegal  = v.findViewById(R.id.frg_settings_legal_btn);
        btnChangePass = v.findViewById(R.id.frg_settings_change_pass_btn);
    }


    private void showDialogEditable(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.dialog_change_pass, null);
        final EditText edtPass = v.findViewById(R.id.dialog_change_pass_pass_edt);
        final EditText edtPassConfirm = v.findViewById(R.id.dialog_change_pass_confirm_edt);

        edtPassConfirm.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {

                boolean action = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    // Cerrar el Teclado
                    InputMethodManager inputMethodManager = (InputMethodManager) textView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(textView.getWindowToken(), 0);

                    // Lanzamos la Accion
                    comprobarPass(edtPass, edtPassConfirm);

                    dialog.dismiss();
                    action = true;
                }
                return action;
            }
        });

        // TODO: Ver Esto
        edtPassConfirm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        builder.setView(v)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        comprobarPass(edtPass, edtPassConfirm);
                    }
                }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        dialog = builder.create();
        dialog.show();
    }

    private void comprobarPass(EditText edtPass, EditText edtPassConfirm){

        String pass = edtPass.getText().toString();
        String confirmacion = edtPassConfirm.getText().toString();

        if (!pass.trim().isEmpty() && pass.equals(confirmacion)){
            Toast toast = Toast.makeText(getActivity(), R.string.pass_confirm_ok, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0 , 0);
            toast.show();
        }else{
            Toast toast = Toast.makeText(getActivity(), R.string.pass_confirm_ko, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0 , 0);
            toast.show();
        }
    }


    private void showDialogLegal(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.dialog_legal_terms, null);
        builder.setView(v)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showAlertDialog(){

        // 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

// 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage(R.string.alert_dialog_msg)
                .setTitle(R.string.alert_dialog_title);

// 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>


// Add the buttons
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });
        builder.setCancelable(false);
        // Set other dialog properties

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    private void doLogout() {
        Settings.init(getActivity()).remove("user");
        Intent intent = new Intent(getActivity(), AuthActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}