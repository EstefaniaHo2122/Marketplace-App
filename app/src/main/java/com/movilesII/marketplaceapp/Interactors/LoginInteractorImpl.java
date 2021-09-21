package com.movilesII.marketplaceapp.Interactors;

import com.movilesII.marketplaceapp.Interfaces.LoginInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginInteractorImpl implements LoginInterface.Interactor {
    @Override
    public void validUser(String email, String password, LoginInterface.onLoginFinishListener listener) {
        Pattern regexEmail = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Pattern regexPassword = Pattern.compile("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{6,20}$");
        Matcher matchEmail = regexEmail.matcher(email);
        Matcher matchPassword = regexPassword.matcher(password);

        if(email.isEmpty() || email.equals("")){
            listener.emailError("Este campo no puede estar vacío.");
        }else if (!matchEmail.find()){
            listener.emailError("Email inválido.");
        }else if (password.isEmpty() || password.equals("")){
            listener.passwordError("Este campo no puede estar vacío.");
        }else if(!matchPassword.find()){
            listener.passwordError("Contraseña inválida.");
        }else {
            listener.emailGood();
            listener.passwordGood();
            listener.successOperations("Validación exitosa..!");
        }
    }
}
