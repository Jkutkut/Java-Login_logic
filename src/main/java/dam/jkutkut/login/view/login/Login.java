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
    private JLabel lblError;

    public Login() {
        setTitle(TITLE);
        setContentPane(jpBody);
        pack();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 200);
        addWindowListener(this);

        initComponents();
    }

    private void initComponents() {

    }

    // SETTERS

    public void setController(Controller controller) {
        btnLogin.addActionListener(controller);
        btnSignUp.addActionListener(controller);
    }

    public void clearError() {
        this.setError("");
    }

    public void setError(String error) {
        if (error.isEmpty() || error == null)
            lblError.setText("");
        else
            lblError.setText("Error: " + error);
    }

    public void resetForm() {
        txtfUser.setText("");
        txtfPasswd.setText("");
    }

    // GETTERS

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JButton getBtnSignUp() {
        return btnSignUp;
    }

    public String getUser() {
        return txtfUser.getText();
    }

    public String getPasswd() {
        return txtfPasswd.getText();
    }

    // Window listener methods
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        int i = JOptionPane.showConfirmDialog(
                this,
                "¿Estás seguro de que quieres salir?",
                "Salir",
                JOptionPane.YES_NO_OPTION
        );
        if (i == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
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
