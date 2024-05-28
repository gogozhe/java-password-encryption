package test;

import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.*;  
import javax.swing.*;  
import test.AccountManager;

public class Login {
    private JFrame ourFrame = new JFrame("Login");
    private JPasswordField password = new JPasswordField();
    private JTextField nameText = new JTextField();
    private AccountManager accountManager;

    public Login(final AccountManager accountManager) {
        this.accountManager = accountManager;

        ourFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ourFrame.setBounds(200, 100, 400, 200);

        Container container = ourFrame.getContentPane();
        container.setLayout(null);

        JLabel logo = new JLabel("Login");
        logo.setBounds(60, 5, 250, 30);

        JLabel name_label = new JLabel("Username: ");
        name_label.setBounds(20, 30, 300, 30);

        JLabel password_label = new JLabel("Password:");
        password_label.setBounds(20, 60, 300, 30);

        nameText.setBounds(85, 30, 250, 30);
        password.setBounds(85, 60, 250, 30);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(100, 90, 100, 30);
        JButton signUpBtn = new JButton("New Here?");
        signUpBtn.setBounds(200, 90, 100, 30);

        container.add(logo);
        container.add(name_label);
        container.add(password_label);
        container.add(nameText);
        container.add(password);
        container.add(loginBtn);
        container.add(signUpBtn);
        ourFrame.setVisible(true);

        signUpBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ourFrame.dispose();
                new Signup(accountManager);
            }
        });

        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                account acc = accountManager.findAccount(nameText.getText());
                if (acc != null) {
                    String enteredPassword = new String(password.getPassword());
                    if (acc.unscramblePassword(enteredPassword).equals(acc.getEncryptedPass())) {
                        ourFrame.dispose();
                        showWelcomeScreen();
                    } else {
                        JOptionPane.showMessageDialog(ourFrame, "Invalid username or password.");
                    }
                } else {
                    JOptionPane.showMessageDialog(ourFrame, "Invalid username or password.");
                }
            }
        });
    }

    private void showWelcomeScreen() {
        JOptionPane.showMessageDialog(null, "Welcome!");
    }
}