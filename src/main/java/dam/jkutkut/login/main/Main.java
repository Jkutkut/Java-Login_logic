package dam.jkutkut.login.main;

import dam.jkutkut.db.AccessDB;
import dam.jkutkut.db.LoginDB;
import dam.jkutkut.login.view.login.Login;
import dam.jkutkut.login.view.signup.SignUp;
import dam.jkutkut.login.controller.Controller;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Login vLogin = new Login();
                SignUp vSignUp = new SignUp();
                LoginDB loginDB = new LoginDB();

                Controller controller = new Controller(vLogin, vSignUp, loginDB);
                vLogin.setController(controller);
                vSignUp.setController(controller);
                vLogin.setVisible(true);
            }
        });
    }
}
