import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome extends JFrame {

    public Welcome() {
        setTitle("Welcome");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Set background image for the frame
        ImageIcon backgroundImage = new ImageIcon("MONEY.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 800, 600);
        add(backgroundLabel);

        JLabel titleLabel = new JLabel("Welcome to Currency Market");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK); // Set text color
        titleLabel.setBounds(250, 50, 400, 50);
        backgroundLabel.add(titleLabel);

        JButton loginButton = createButton("Login", 150);
        JButton signInButton = createButton("Sign in", 225);
        JButton forgotPasswordButton = createButton("Forgot Password", 300);
        JButton exitButton = createButton("Exit", 375);

        backgroundLabel.add(loginButton);
        backgroundLabel.add(signInButton);
        backgroundLabel.add(forgotPasswordButton);
        backgroundLabel.add(exitButton);

        loginButton.addActionListener(new LoginListener());
        signInButton.addActionListener(new SignInListener());
        forgotPasswordButton.addActionListener(new ForgotPasswordListener());
        exitButton.addActionListener(new ExitListener());

        setVisible(true);
    }

    private JButton createButton(String text, int y) {
        JButton button = new JButton(text);
        button.setBounds(300, y, 200, 50);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setOpaque(false); // Make button transparent
        button.setContentAreaFilled(false); // Make button transparent
        button.setBorderPainted(false); // Make button transparent
        button.setForeground(Color.BLACK); // Set text color
		button.setBackground(Color.BLACK);
        return button;
    }

    private class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dispose();
            new Login().setVisible(true);
        }
    }

    private class SignInListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dispose();
            new Sigin().setVisible(true);
        }
    }

    private class ForgotPasswordListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dispose();
            new ForgotPasswordPage().setVisible(true);
        }
    }

    private class ExitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Welcome();
    }
}
