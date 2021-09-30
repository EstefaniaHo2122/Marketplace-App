package com.movilesII.marketplaceapp.Interfaces;

public interface LoginInterface {

    interface Interactor {
        void validUser(String email, String password, onLoginFinishListener listener);

    }
    interface Presenter {
        void validLogin(String email, String password);
    }
    interface Views {
        void setErrorEmail(String errorMessage);
        void setErrorPassword(String errorMessage);
        void clearErrorEmail();
        void clearErrorPassword();
        void isValidCredentials(String successMessage);
        void navigateToSignUp();
    }
    interface onLoginFinishListener{
        void emailError(String errorText);
        void emailGood();
        void passwordError(String errorText);
        void passwordGood();
        void successOperations(String messageSucces);
    }
}
