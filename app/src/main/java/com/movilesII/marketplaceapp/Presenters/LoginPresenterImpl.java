package com.movilesII.marketplaceapp.Presenters;

import com.movilesII.marketplaceapp.Interactors.LoginInteractorImpl;
import com.movilesII.marketplaceapp.Interfaces.LoginInterface;

public class LoginPresenterImpl implements LoginInterface.Presenter, LoginInterface.onLoginFinishListener {

    private LoginInterface.Views view;
    private LoginInterface.Interactor interactor;

    public LoginPresenterImpl(LoginInterface.Views view) {
        this.view = view;
        interactor = new LoginInteractorImpl();
    }

    @Override
    public void validLogin(String email, String password) {
        if (view != null){
            interactor.validUser(email, password, this);
        }
    }

    @Override
    public void emailError(String errorText) {
        if (view != null){
            view.setErrorEmail(errorText);
        }
    }

    @Override
    public void emailGood() {
        if (view != null){
            view.clearErrorEmail();
        }
    }

    @Override
    public void passwordError(String errorText) {
        if (view != null) {
            view.setErrorPassword(errorText);
        }
    }

    @Override
    public void passwordGood() {
        if (view != null){
            view.clearErrorPassword();
        }
    }

    @Override
    public void successOperations(String messageSucces) {
        if (view != null) {
            view.isValidCredentials(messageSucces);
        }
    }
}
