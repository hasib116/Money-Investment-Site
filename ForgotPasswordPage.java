import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgotPasswordPage extends JFrame {

    public ForgotPasswordPage() {
        setTitle("Forgot Password");
        setSize(800, 600);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel titleLabel = new JLabel("Forgot Password");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(300, 50, 200, 50);
        add(titleLabel);

        JLabel emailLabel = new JLabel("Enter your email:");
        emailLabel.setBounds(200, 150, 150, 30);
        add(emailLabel);

        JTextField emailTextField = new JTextField();
        emailTextField.setBounds(350, 150, 250, 30);
        add(emailTextField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(300, 250, 200, 50);
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                JOptionPane.showMessageDialog(null, "New Password  sent to your email!");
            }
        });

        JButton backButton = new JButton("Back to Home");
        backButton.setBounds(300, 350, 200, 50);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                dispose(); 
                new Welcome().setVisible(true); 
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new ForgotPasswordPage();
    }
}
