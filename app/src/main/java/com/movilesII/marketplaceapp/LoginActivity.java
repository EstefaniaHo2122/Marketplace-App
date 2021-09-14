package com.movilesII.marketplaceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin;
    TextView tvGotoSignupActivity;
    ValidateClass validar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        validar = new ValidateClass();
        validar.setFieldEmail(findViewById(R.id.etEmailLogin));
        validar.setFieldPassword(findViewById(R.id.etPasswordLogin));

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        tvGotoSignupActivity = findViewById(R.id.tvGoSignup);
        tvGotoSignupActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnLogin:
                if (validar.validateLogin()){
                    Toast.makeText(this, "Validación Exitosa", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Error en la validacion", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tvGoSignup:
                Intent intent = new Intent(this, SignupActivity.class);
                this.startActivity(intent);
                break;
        }
    }
}