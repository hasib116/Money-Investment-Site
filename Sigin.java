import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class Sigin extends JFrame {

    private JTextField usernameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JComboBox<String> genderComboBox;
    private JTextField birthDateField;
    private JTextField addressField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    public Sigin() {
        setTitle("Account Creation");
        setBounds(200, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
		
	

        JLabel titleLabel = new JLabel("Create an Account");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(300, 20, 200, 30);
        add(titleLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 70, 100, 30);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(200, 70, 200, 30);
        add(usernameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 120, 100, 30);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(200, 120, 200, 30);
        add(emailField);

        JLabel phoneLabel = new JLabel("Phone No:");
        phoneLabel.setBounds(50, 170, 100, 30);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(200, 170, 200, 30);
        add(phoneField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 220, 100, 30);
        add(genderLabel);

        String[] genders = {"Male", "Female", "Other"};
        genderComboBox = new JComboBox<>(genders);
        genderComboBox.setBounds(200, 220, 200, 30);
        add(genderComboBox);

        JLabel birthDateLabel = new JLabel("Birth Date:");
        birthDateLabel.setBounds(50, 270, 100, 30);
        add(birthDateLabel);

        birthDateField = new JTextField();
        birthDateField.setBounds(200, 270, 200, 30);
        add(birthDateField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(50, 320, 100, 30);
        add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(200, 320, 200, 30);
        add(addressField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 370, 100, 30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(200, 370, 200, 30);
        add(passwordField);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(50, 420, 150, 30);
        add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(200, 420, 200, 30);
        add(confirmPasswordField);

        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(300, 500, 150, 30);
        add(createAccountButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(150, 500, 150, 30);
        add(backButton);

        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                String gender = (String) genderComboBox.getSelectedItem();
                String birthDate = birthDateField.getText();
                String address = addressField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                // Perform validation
                if (username.isEmpty() || email.isEmpty() || phone.isEmpty() || birthDate.isEmpty() || address.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(Sigin.this, "Please fill in all fields.");
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(Sigin.this, "Passwords do not match.");
                } else {
                    // Save user information to a text file
                    saveUserInfo(username, email, phone, gender, birthDate, address, password);
                    JOptionPane.showMessageDialog(Sigin.this, "Account created successfully!");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Simply close the current frame and return to previous page or exit
                dispose();
                new Welcome().setVisible(true);
            }
        });

        setVisible(true);
    }

    private void saveUserInfo(String username, String email, String phone, String gender, String birthDate, String address, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user_info.txt", true))) {
		writer.write(username + ":" + password +"\n" );
            writer.write("Username: " + username + "\n");
            writer.write("Email: " + email + "\n");
            writer.write("Phone No: " + phone + "\n");
            writer.write("Gender: " + gender + "\n");
            writer.write("Birth Date: " + birthDate + "\n");
            writer.write("Address: " + address + "\n");
            writer.write("Password: " + password + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create an instance of Sigin
        SwingUtilities.invokeLater(() -> new Sigin());
    }
}
