package com.movilesII.marketplaceapp.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.movilesII.marketplaceapp.Interfaces.RegisterInterface;
import com.movilesII.marketplaceapp.Presenters.RegisterPresenterImpl;
import com.movilesII.marketplaceapp.R;

public class RegisterViewImpl extends AppCompatActivity implements RegisterInterface.View, View.OnClickListener {

    private Button btnRegister;
    private TextView tvGoToLogin;
    private TextInputLayout etName, etLastname, etEmail, etPassword;
    private RegisterInterface.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_register);

        etName = findViewById(R.id.etName);
        etLastname = findViewById(R.id.etLastName);
        etEmail = findViewById(R.id.etEmailRegister);
        etPassword = findViewById(R.id.etPasswordRegister);

        presenter = new RegisterPresenterImpl(this);

       btnRegister = findViewById(R.id.btnSignup);
       btnRegister.setOnClickListener(this);
       tvGoToLogin = findViewById(R.id.tvGoLogin);
       tvGoToLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnSignup:
                registerValidation();
                break;
            case R.id.tvGoLogin:
                navigateToLogin();
                break;
        }
    }

    @Override
    public void setErrorName(String errorName) {
        etName.setErrorEnabled(true);
        etName.setError(errorName);
        etName.requestFocus();
    }

    @Override
    public void clearErrorName() {
        etName.setErrorEnabled(false);
    }

    @Override
    public void setErrorLastname(String errorLastname) {
        etLastname.setErrorEnabled(true);
        etLastname.setError(errorLastname);
        etLastname.requestFocus();
    }

    @Override
    public void clearErrorLastname() {
        etLastname.setErrorEnabled(false);
    }

    @Override
    public void setErrorEmail(String errorEmail) {
        etEmail.setErrorEnabled(true);
        etEmail.setError(errorEmail);
        etEmail.requestFocus();
    }

    @Override
    public void clearErrorEmail() {
        etEmail.setErrorEnabled(false);
    }

    @Override
    public void setErrorPassword(String errorPassword) {
        etPassword.setErrorEnabled(true);
        etPassword.setError(errorPassword);
        etPassword.requestFocus();
    }

    @Override
    public void clearErrorPassword() {
        etPassword.setErrorEnabled(false);
    }

    @Override
    public void isValidRegister(String validRegister) {
        Toast.makeText(this, validRegister, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToLogin() {
        Intent intent = new Intent(this, LoginViewImpl.class);
        this.startActivity(intent);
    }

    public void registerValidation(){
        String name, lastname, email, password;
        name = etName.getEditText().getText().toString().trim();
        lastname = etLastname.getEditText().getText().toString().trim();
        email = etEmail.getEditText().getText().toString().trim();
        password = etPassword.getEditText().getText().toString().trim();
        presenter.validRegister(name, lastname, email, password);
    }
}