import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login extends JFrame {
    // File path to store user information
    private static final String USER_INFO_FILE = "user_info.txt";
	 private ImageIcon img;
    private JLabel imageLabel;


    public Login() {
        setTitle("Login Page");
        setBounds(200, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
		
		
		img = new ImageIcon(Login.class.getResource("login.png")); 
        imageLabel = new JLabel(img);
        imageLabel.setBounds(300, 70, 200, 210);
        add(imageLabel);

        JLabel berLabel = new JLabel(" " + "   Log In ");
        berLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        berLabel.setBounds(350, 265, 100, 25);
        add(berLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Sans Serif", Font.BOLD, 16));
        usernameLabel.setBounds(200, 300, 100, 25);
        panel.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(300, 300, 200, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Sans Serif", Font.BOLD, 16));
        passwordLabel.setBounds(200, 350, 100, 25);
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(300, 350, 200, 25);
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Sans Serif", Font.BOLD, 16));
        loginButton.setBounds(300, 400, 90, 25);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Check if entered credentials match any registered user
                if (checkCredentials(username, password)) {
                    dispose();
                    new Home().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
                }
            }
        });
        panel.add(loginButton);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Sans Serif", Font.BOLD, 16));
        backButton.setBounds(400, 400, 90, 25);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Welcome().setVisible(true);
            }
        });
        panel.add(backButton);

        add(panel);
        setVisible(true);
    }

    private boolean checkCredentials(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_INFO_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split each line by ":" to separate username and password
                String[] parts = line.split(":");
                if (parts.length == 2 && parts[0].trim().equals(username) && parts[1].trim().equals(password)) {
                    return true; // Found a matching username and password
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // No matching username and password found
    }

    public static void main(String[] args) {
        new Login();
    }
}
