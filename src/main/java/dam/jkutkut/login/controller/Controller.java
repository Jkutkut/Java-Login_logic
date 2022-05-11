package dam.jkutkut.login.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dam.jkutkut.exception.InvalidDataException;
import dam.jkutkut.login.view.login.Login;
import dam.jkutkut.login.view.signup.SignUp;
import dam.jkutkut.passwordPolicy.model.PasswordPolicy;
import dam.jkutkut.passwordPolicy.model.UserPolicy;

public class Controller implements ActionListener {
    private Login vLogin;
    private SignUp vSignUp;

    private UserPolicy userPolicy;
    private PasswordPolicy passwordPolicy;

    public Controller(Login vLogin, SignUp vSignUp) {
        this.vLogin = vLogin;
        this.vSignUp = vSignUp;

        userPolicy = new UserPolicy();
        passwordPolicy = new PasswordPolicy();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == vLogin.getBtnLogin())
                login();
            else if (button == vLogin.getBtnSignUp())
                signup();
        }
    }

    private void login() {
        String username = vLogin.getTxtfUser().getText();
        String password = vLogin.getTxtfPasswd().getText();

        try {
            userPolicy.validate(username);
            passwordPolicy.validate(password);
        }
        catch (InvalidDataException e) {
            vLogin.setError(e.getMessage());
        }
    }

    private void signup() {

    }
}
