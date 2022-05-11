package dam.jkutkut.login.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dam.jkutkut.login.view.login.Login;
import dam.jkutkut.login.view.signup.SignUp;

public class Controller implements ActionListener {
    private Login vLogin;
    private SignUp vSignUp;

    public Controller(Login vLogin, SignUp vSignUp) {
        this.vLogin = vLogin;
        this.vSignUp = vSignUp;
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

    }

    private void signup() {

    }
}
