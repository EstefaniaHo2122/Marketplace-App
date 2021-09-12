package com.movilesII.marketplaceapp;

import com.google.android.material.textfield.TextInputLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClass {
    private String name;
    private String lastname;
    private String email;
    private String password;

    private TextInputLayout fieldName;
    private TextInputLayout fieldLastname;
    private TextInputLayout fieldEmail;
    private TextInputLayout fieldPassword;

    public ValidateClass() {
    }

    public TextInputLayout getFieldName() {
        return fieldName;
    }

    public void setFieldName(TextInputLayout fieldName) {
        this.fieldName = fieldName;
    }

    public TextInputLayout getFieldLastname() {
        return fieldLastname;
    }

    public void setFieldLastname(TextInputLayout fieldLastname) {
        this.fieldLastname = fieldLastname;
    }

    public TextInputLayout getFieldEmail() {
        return fieldEmail;
    }

    public void setFieldEmail(TextInputLayout fieldEmail) {
        this.fieldEmail = fieldEmail;
    }

    public TextInputLayout getFieldPassword() {
        return fieldPassword;
    }

    public void setFieldPassword(TextInputLayout fieldPassword) {
        this.fieldPassword = fieldPassword;
    }

    private boolean validateName(){
        this.name = this.fieldName.getEditText().getText().toString();
        Pattern regex = Pattern.compile("[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$");
        Matcher matcher = regex.matcher(this.name);

        if(this.name.isEmpty() || this.name == ""){
            this.fieldName.setErrorEnabled(true);
            this.fieldName.setError("Este campo no puede estar vacío.");
            return false;
        }else if(!matcher.matches()){
            this.fieldName.setErrorEnabled(true);
            this.fieldName.setError("Contiene tiene caracteres no permitidos.");
            return false;
        }
        this.fieldName.setErrorEnabled(false);
        this.fieldName.setError("");
        return true;
    }

    private boolean validateLastname(){
        this.lastname = fieldLastname.getEditText().getText().toString();
        Pattern regex = Pattern.compile("[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$");
        Matcher matcher = regex.matcher(this.lastname);

        if(this.lastname.isEmpty() || this.lastname == ""){
            fieldLastname.setErrorEnabled(true);
            fieldLastname.setError("Este campo no puede estar vacío.");
            return false;
        }else if(!matcher.matches()){
            fieldLastname.setErrorEnabled(true);
            fieldLastname.setError("Contiene caracteres no permitidos.");
            return false;
        }
        fieldLastname.setErrorEnabled(false);
        fieldLastname.setError("");
        return true;
    }

    private boolean validateEmail(){
        this.email = fieldEmail.getEditText().getText().toString();
        Pattern regex = Pattern.compile("[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$");
        Matcher matcher = regex.matcher(this.email);

        if(this.email.isEmpty() || this.email == ""){
            fieldEmail.setErrorEnabled(true);
            fieldEmail.setError("Este campo no puede estar vacío");
            return false;
        }else if(!matcher.matches()){
            fieldLastname.setErrorEnabled(true);
            fieldLastname.setError("Contiene caracteres no permitidos.");
            return false;
        }
        fieldEmail.setErrorEnabled(false);
        fieldEmail.setError("");
        return true;
    }

    public boolean validate(){
        if(validateName() || validateLastname() || validateEmail()){
            return true;
        }
        return false;
    }
}
