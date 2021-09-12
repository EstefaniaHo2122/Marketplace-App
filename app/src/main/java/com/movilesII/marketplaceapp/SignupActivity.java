package com.movilesII.marketplaceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAccountCreate;
    ValidateClass validar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

       validar = new ValidateClass();
       validar.setFieldName(findViewById(R.id.etNameSignup));
       validar.setFieldLastname(findViewById(R.id.etLastNameSignup));
       validar.setFieldEmail(findViewById(R.id.etEmailSignup));
       validar.setFieldPassword(findViewById(R.id.etPasswordSignup));

       btnAccountCreate = findViewById(R.id.btnSignup);
       btnAccountCreate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnSignup:
                if(validar.validate()){
                    Toast.makeText(this, "Validación Exitosa", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Error en la validacion", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }




}