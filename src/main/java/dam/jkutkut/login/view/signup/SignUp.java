package dam.jkutkut.login.view.signup;

import dam.jkutkut.login.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SignUp extends JFrame implements WindowListener {
    private static final String TITLE = "Sign Up";

    private JPanel jpForm;
    private JTextField txtfUser;
    private JTextField txtfPasswd1;
    private JTextField txtfPassswd2;
    private JButton btnConfirm;
    private JButton btnCancel;
    private JLabel lblUser;
    private JLabel lblPasswd1;
    private JLabel lblPassswd2;
    private JPanel jpButtons;
    private JPanel jpBody;
    private JLabel lblError;

    private Controller controller;

    public SignUp() {
        setTitle(TITLE);
        setContentPane(jpBody);
        pack();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 250);
        addWindowListener(this);

        initComponents();
    }

    private void initComponents() {
    }

    // SETTERS
    public void setController(Controller controller) {
        btnConfirm.addActionListener(controller);
        btnCancel.addActionListener(controller);

        this.controller = controller;
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
        txtfPasswd1.setText("");
        txtfPassswd2.setText("");
    }

    // GETTERS

    public JButton getBtnConfirm() {
        return btnConfirm;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public String getUser() {
        return txtfUser.getText();
    }

    public String[] getPasswd() {
        return new String[]{txtfPasswd1.getText(), txtfPassswd2.getText()};
    }

    // Window listener methods
    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        controller.actionPerformed(new ActionEvent(btnCancel, 0, ""));
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
        resetForm();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        resetForm();
    }
}
