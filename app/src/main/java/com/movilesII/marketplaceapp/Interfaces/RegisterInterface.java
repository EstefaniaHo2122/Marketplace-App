package com.movilesII.marketplaceapp.Interfaces;

public interface RegisterInterface {

    interface Interactor {
        void validRegister(String name, String lastName, String email, String password, OnRegisterFinishListener listener);
    }
    interface Presenter {
        void validRegister(String name, String lastName, String email, String password);
    }
    interface View {
        void setErrorName(String errorName);
        void clearErrorName();
        void setErrorLastname(String errorLastname);
        void clearErrorLastname();
        void setErrorEmail(String errorEmail);
        void clearErrorEmail();
        void setErrorPassword (String errorPassword);
        void clearErrorPassword();
        void isValidRegister(String validRegister);
        void navigateToLogin();
    }
    interface OnRegisterFinishListener{
        void nameError(String errorTextName);
        void nameGood();
        void lastnameError(String errorTextLastname);
        void lastnameGood();
        void emailError(String errorTextEmail);
        void emailGood();
        void passwordError(String errorTextPassword);
        void passwordGood();
        void onOperationsGood(String messageSuccess);
    }
}
