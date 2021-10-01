package com.movilesII.marketplaceapp.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.movilesII.marketplaceapp.Interfaces.LoginInterface;
import com.movilesII.marketplaceapp.Presenters.LoginPresenterImpl;
import com.movilesII.marketplaceapp.R;

public class LoginViewImpl extends AppCompatActivity implements LoginInterface.Views, View.OnClickListener {

    private Button btnLogin;
    private TextView tvGotoSignupActivity;
    private TextInputLayout etEmail, etPassword;
    private LoginInterface.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_login);

        etEmail = findViewById(R.id.etEmailLogin);
        etPassword = findViewById(R.id.etPasswordLogin);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        tvGotoSignupActivity = findViewById(R.id.tvGoSignup);
        tvGotoSignupActivity.setOnClickListener(this);

        presenter = new LoginPresenterImpl(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnLogin:
                doValidations();
                break;
            case R.id.tvGoSignup:
                navigateToSignUp();
                break;
        }
    }

    @Override
    public void setErrorEmail(String errorMessage) {
        etEmail.setErrorEnabled(true);
        etEmail.setError(errorMessage);
        etEmail.requestFocus();
    }

    @Override
    public void setErrorPassword(String errorMessage) {
        etPassword.setErrorEnabled(true);
        etPassword.setError(errorMessage);
        etPassword.requestFocus();
    }

    @Override
    public void clearErrorEmail() {
        etEmail.setErrorEnabled(false);
    }

    @Override
    public void clearErrorPassword() {
        etPassword.setErrorEnabled(false);
    }

    @Override
    public void isValidCredentials(String successMessage) {
        Toast.makeText(this, successMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToSignUp() {
        Intent intent = new Intent(this, RegisterViewImpl.class);
        this.startActivity(intent);
    }

    public void doValidations(){
        String emailText = etEmail.getEditText().getText().toString().trim();
        String passwordText = etPassword.getEditText().getText().toString().trim();
        presenter.validLogin(emailText, passwordText);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}