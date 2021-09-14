package com.movilesII.marketplaceapp;

import android.content.Context;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClass {

    private TextInputLayout fieldLastname;
    private TextInputLayout fieldEmail;
    private TextInputLayout fieldPassword;
    private TextInputLayout fieldName;

    public ValidateClass() {
    }

    public void setFieldName(TextInputLayout fieldName) {
        this.fieldName = fieldName;
    }

    public void setFieldLastname(TextInputLayout fieldLastname) {
        this.fieldLastname = fieldLastname;
    }

    public void setFieldEmail(TextInputLayout fieldEmail) {
        this.fieldEmail = fieldEmail;
    }

    public void setFieldPassword(TextInputLayout fieldPassword) {
        this.fieldPassword = fieldPassword;
    }

    private boolean validateName(){
        String name = this.fieldName.getEditText().getText().toString().trim();
        Pattern regex = Pattern.compile("^[A-Za-z]+[\\s]?([A-Za-z]+)*\\S$");
        Matcher matcher = regex.matcher(name);

        if(name.isEmpty() || name == ""){
            this.fieldName.setErrorEnabled(true);
            this.fieldName.setError("Este campo no puede estar vacío.");
            return false;
        }else if(!matcher.matches()){
            this.fieldName.setErrorEnabled(true);
            this.fieldName.setError("Nombre no válido (Maximo dos nombres).");
            return false;
        }
        this.fieldName.setErrorEnabled(false);
        this.fieldName.setError("");
        return true;
    }

    private boolean validateLastname(){
        String lastname = fieldLastname.getEditText().getText().toString().trim();
        Pattern regex = Pattern.compile("^[A-Za-z]+[\\s]?([A-Za-z]+)*\\S$");
        Matcher matcher = regex.matcher(lastname);

        if(lastname.isEmpty() || lastname == ""){
            fieldLastname.setErrorEnabled(true);
            fieldLastname.setError("Este campo no puede estar vacío.");
            return false;
        }else if(!matcher.matches()){
            fieldLastname.setErrorEnabled(true);
            fieldLastname.setError("Apellido no válido (Maximo dos apellidos).");
            return false;
        }
        fieldLastname.setErrorEnabled(false);
        fieldLastname.setError("");
        return true;
    }

    private boolean validateEmail(){
        String email = fieldEmail.getEditText().getText().toString().trim();
        Pattern regex = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mat = regex.matcher(email);

        if(email.isEmpty() || email == ""){
            fieldEmail.setErrorEnabled(true);
            fieldEmail.setError("Este campo no puede estar vacío.");
            return false;
        }else if(!mat.find()){
            fieldEmail.setErrorEnabled(true);
            fieldEmail.setError("Email inválido.");
            return false;
        }
        fieldEmail.setErrorEnabled(false);
        fieldEmail.setError("");
        return true;
    }

    private boolean validatePassword(){
        Pattern pattern = Pattern.compile("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{6,20}$");
        String password = fieldPassword.getEditText().getText().toString().trim();
        Matcher mat = pattern.matcher(password);


        if (password.isEmpty() || password == "" || password == null){
            fieldPassword.setErrorEnabled(true);
            fieldPassword.setError("Este campo no puede estar vacío.");
            return false;
        }
        if (!mat.matches()){
            fieldPassword.setErrorEnabled(true);
            fieldPassword.setError("Contraseña no válida.");
            return false;
        }
        fieldPassword.setError("");
        fieldPassword.setErrorEnabled(false);
        return true;
    }

    public boolean validate(){
        if (!validateName()){
            fieldName.requestFocus();
            return false;
        }
        if(!validateLastname()){
            fieldLastname.requestFocus();
            return false;
        }
        if(!validateEmail()){
            fieldEmail.requestFocus();
            return false;
        }
        if(!validatePassword()){
            fieldPassword.requestFocus();
            return false;
        }
        return true;
    }

    public boolean validateLogin(){
        if(!validateEmail()){
            fieldEmail.requestFocus();
            return false;
        }
        if(!validatePassword()){
            fieldPassword.requestFocus();
            return false;
        }
        return true;
    }
}
