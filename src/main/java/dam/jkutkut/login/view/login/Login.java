package dam.jkutkut.login.view.login;

import dam.jkutkut.login.controller.Controller;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Login extends JFrame implements WindowListener {
    private static final String TITLE = "Login";

    private JPanel jpBody;
    private JPanel jpForm;
    private JTextField txtfUser;
    private JTextField txtfPasswd;
    private JPanel jpButtons;
    private JButton btnLogin;
    private JButton btnSignUp;
    private JLabel lblUser;
    private JLabel lblPasswd;

    public Login() {
        setTitle(TITLE);
        setContentPane(jpBody);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {

    }

    public void setController(Controller controller) {
//        .addActionListener(controller);
    }

    // GETTERS



    // Window listener methods
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
