package test;
import test.account;
import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.*;  
import javax.swing.*;  
import test.AccountManager;
public class Signup {
    private JFrame ourFrame = new JFrame("Sign Up");
    private JPasswordField password = new JPasswordField();
    private JPasswordField encryptKey = new JPasswordField();
    private JTextField nameText = new JTextField();
    private AccountManager accountManager;

    public Signup(final AccountManager accountManager) {
        this.accountManager = accountManager;

        ourFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ourFrame.setBounds(200, 100, 400, 200);

        Container container = ourFrame.getContentPane();
        container.setLayout(null);

        JLabel logo = new JLabel("Sign Up");
        logo.setBounds(60, 5, 250, 30);

        JLabel name_label = new JLabel("Username: ");
        name_label.setBounds(20, 30, 300, 30);

        JLabel password_label = new JLabel("Password:");
        password_label.setBounds(20, 60, 300, 30);

        JLabel key_label = new JLabel("Encryption Key:");
        key_label.setBounds(20, 90, 300, 30);

        nameText.setBounds(125, 30, 250, 30);
        password.setBounds(125, 60, 250, 30);
        encryptKey.setBounds(125, 90, 250, 30);

        JButton signUpBtn = new JButton("Sign Up");
        signUpBtn.setBounds(100, 120, 100, 30);
        JButton loginBtn = new JButton("Login?");
        loginBtn.setBounds(200, 120, 100, 30);

        container.add(logo);
        container.add(name_label);
        container.add(password_label);
        container.add(nameText);
        container.add(password);
        container.add(loginBtn);
        container.add(signUpBtn);
        container.add(encryptKey);
        container.add(key_label);
        ourFrame.setVisible(true);

        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ourFrame.dispose();
                new Login(accountManager);
            }
        });

        signUpBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                account acc = new account();
                acc.setUserName(nameText.getText());
                String passwordS = new String(password.getPassword());
                acc.setPassword(passwordS);
                String keyS = new String(encryptKey.getPassword());
                acc.setEncryptionKey(keyS);
                acc.scramblePassword();
                accountManager.addAccount(acc);
                JOptionPane.showMessageDialog(ourFrame, "Account created successfully!");
            }
        });
    }
}