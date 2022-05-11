package dam.jkutkut.login.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dam.jkutkut.db.LoginDB;
import dam.jkutkut.exception.InvalidDataException;
import dam.jkutkut.login.view.login.Login;
import dam.jkutkut.login.view.signup.SignUp;
import dam.jkutkut.passwordPolicy.model.BasicPasswordPolicy;
import dam.jkutkut.passwordPolicy.model.UserPolicy;

public class Controller implements ActionListener {
    private Login vLogin;
    private SignUp vSignUp;
    private LoginDB loginDB;

    private UserPolicy userPolicy;
    private BasicPasswordPolicy passwordPolicy;

    public Controller(Login vLogin, SignUp vSignUp, LoginDB loginDB) {
        this.vLogin = vLogin;
        this.vSignUp = vSignUp;
        this.loginDB = loginDB;

        userPolicy = new UserPolicy();
        passwordPolicy = new BasicPasswordPolicy();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == vLogin.getBtnLogin())
                login();
            else if (button == vLogin.getBtnSignUp())
                openSignup();
            else if (button == vSignUp.getBtnConfirm())
                signup();
            else if (button == vSignUp.getBtnCancel())
                closeSignup();
        }
    }

    private void openSignup() {
        vLogin.setVisible(false);
        vSignUp.setVisible(true);
    }

    private void closeSignup() {
        vLogin.setVisible(true);
        vSignUp.setVisible(false);
    }

    private void signup() {
        String username = vSignUp.getUser();
        String[] password = vSignUp.getPasswd();

        try {
            userPolicy.validate(username);
            if (!password[0].equals(password[1]))
                throw new InvalidDataException("Passwords do not match");
            passwordPolicy.validate(password[0]);

            vSignUp.clearError();
            JOptionPane.showMessageDialog(null, "Login successful");
        }
        catch (InvalidDataException e) {
            vSignUp.setError(e.getMessage());
        }
    }

    private void login() {
        String username = vLogin.getUser();
        String password = vLogin.getPasswd();

        try {


            vLogin.clearError();
        }
        catch (InvalidDataException e) {
            vLogin.setError(e.getMessage());
        }
    }
}
