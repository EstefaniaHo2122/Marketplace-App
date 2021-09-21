package com.movilesII.marketplaceapp.Presenters;

import com.movilesII.marketplaceapp.Interactors.RegisterInteractorImpl;
import com.movilesII.marketplaceapp.Interfaces.RegisterInterface;

public class RegisterPresenterImpl implements RegisterInterface.Presenter, RegisterInterface.OnRegisterFinishListener {
    private RegisterInterface.View view;
    private RegisterInterface.Interactor interactor;

    public RegisterPresenterImpl(RegisterInterface.View view) {
        this.view = view;
        interactor = new RegisterInteractorImpl();
    }

    @Override
    public void validRegister(String name, String lastName, String email, String password) {
        if (view != null){
            interactor.validRegister(name, lastName, email, password, this);
        }
    }

    @Override
    public void nameError(String errorTextName) {
        if (view != null){
            view.setErrorName(errorTextName);
        }
    }

    @Override
    public void nameGood() {
        if (view != null){
            view.clearErrorName();
        }
    }

    @Override
    public void lastnameError(String errorTextLastname) {
        if (view != null){
            view.setErrorLastname(errorTextLastname);
        }
    }

    @Override
    public void lastnameGood() {
        if (view != null){
            view.clearErrorLastname();
        }
    }

    @Override
    public void emailError(String errorTextEmail) {
        if (view != null){
            view.setErrorEmail(errorTextEmail);
        }
    }

    @Override
    public void emailGood() {
        if (view != null){
            view.clearErrorEmail();
        }
    }

    @Override
    public void passwordError(String errorTextPassword) {
        if (view != null){
            view.setErrorPassword(errorTextPassword);
        }
    }

    @Override
    public void passwordGood() {
        if (view != null){
            view.clearErrorPassword();
        }
    }

    @Override
    public void onOperationsGood(String messageSuccess) {
        if (view != null){
            view.isValidRegister(messageSuccess);
        }
    }
}
