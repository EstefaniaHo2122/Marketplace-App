package com.movilesII.marketplaceapp.Interactors;

import com.movilesII.marketplaceapp.Interfaces.RegisterInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterInteractorImpl implements RegisterInterface.Interactor {
    @Override
    public void validRegister(String name, String lastName, String email, String password, RegisterInterface.OnRegisterFinishListener listener) {
        Pattern regexEmail = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Pattern regexPassword = Pattern.compile("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{6,20}$");
        Pattern regexNames = Pattern.compile("^[A-Za-z]+[\\s]?([A-Za-z]+)*\\S$");
        Matcher matchEmail = regexEmail.matcher(email);
        Matcher matchPassword = regexPassword.matcher(password);
        Matcher matchName = regexNames.matcher(name);
        Matcher matchLastname = regexNames.matcher(lastName);

        if (name.isEmpty() || name.equals("")){
            listener.nameError("Campo no puede estar vacío!");
        }else if (!matchName.find()){
            listener.nameError("Nombre no válido!");
        }else if (lastName.isEmpty() || lastName.equals("")){
            listener.lastnameError("Campo no puede estar vacío!");
        }else if (!matchLastname.find()){
            listener.lastnameError("Apellido no válido!");
        }else if (email.isEmpty() || email.equals("")){
            listener.emailError("Campo no puede estar vacío!");
        }else if (!matchEmail.find()){
            listener.emailError("Correo electrónico no válido!");
        }else if (password.isEmpty() || password.equals("")){
            listener.passwordError("Campo no puede estar vacío!");
        }else if (!matchPassword.find()){
            listener.passwordError("Contraseña no válido!");
        }else {
            listener.nameGood();
            listener.lastnameGood();
            listener.emailGood();
            listener.passwordGood();
            listener.onOperationsGood("Validación exitosa!");
        }

    }
}
