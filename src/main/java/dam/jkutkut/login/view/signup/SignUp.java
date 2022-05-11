package dam.jkutkut.login.view.signup;

import dam.jkutkut.login.controller.Controller;

import javax.swing.*;

public class SignUp extends JFrame {
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

    public SignUp() {
        setTitle(TITLE);
        setContentPane(jpBody);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 200);

        initComponents();
    }

    private void initComponents() {

    }

    // SETTERS
    public void setController(Controller controller) {
        btnConfirm.addActionListener(controller);
        btnCancel.addActionListener(controller);
    }

    // GETTERS

}
