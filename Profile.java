import javax.swing.*;
import java.awt.*;

public class Profile extends JFrame {

    private ImageIcon img;
    private JLabel imageLabel;
    private JButton backButton, logoutButton;

    public Profile() {

        setTitle("Profile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel profileLabel = new JLabel("Profile", SwingConstants.CENTER);
        profileLabel.setFont(new Font("Sans Serif", Font.BOLD, 24));
        topPanel.add(profileLabel, BorderLayout.NORTH);

        img = new ImageIcon(Profile.class.getResource("profile.jpg")); // Corrected from "getclass()" to "Profile.class"
        imageLabel = new JLabel(img);
        imageLabel.setBounds(100, 100, 600, 200);
        add(imageLabel);

        JLabel madeMoneyLabel = new JLabel("I made money", SwingConstants.CENTER);
        madeMoneyLabel.setFont(new Font("Sans Serif", Font.BOLD, 16));
        topPanel.add(madeMoneyLabel, BorderLayout.CENTER);

        JPanel labelsPanel = new JPanel(null);
        labelsPanel.setPreferredSize(new Dimension(800, 600));

        labelsPanel.add(createLabel("About Me", 50, 300, 100, 50, new Font("Sans Serif", Font.BOLD, 18)));
        JTextArea aboutMeTextArea = new JTextArea("I am a web developer.");
        aboutMeTextArea.setBounds(50, 360, 400, 200);
        aboutMeTextArea.setEditable(false);
        labelsPanel.add(aboutMeTextArea);
        labelsPanel.add(createLabel("Details", 550, 300, 100, 50, new Font("Sans Serif", Font.BOLD, 18)));
        labelsPanel.add(createLabel("Name:", 550, 360, 100, 50));
        labelsPanel.add(createLabel("Hasibul", 660, 360, 100, 50));
        labelsPanel.add(createLabel("Age:", 550, 420, 100, 50));
        labelsPanel.add(createLabel("21", 660, 420, 100, 50));
        labelsPanel.add(createLabel("Location:", 550, 480, 100, 50));
        labelsPanel.add(createLabel("Dhaka", 660, 480, 100, 50));

        // Add panels to frame
        add(topPanel, BorderLayout.PAGE_START);
        add(labelsPanel, BorderLayout.CENTER);

        logoutButton = new JButton("LogOut");
        logoutButton.setBounds(620, 550, 80, 30);
        logoutButton.addActionListener(e -> {
            dispose();
            new Login().setVisible(true);
        });
        labelsPanel.add(logoutButton);

        backButton = new JButton("Back");
        backButton.setBounds(710, 550, 80, 30);
        backButton.addActionListener(e -> {
            dispose();
            new Home().setVisible(true);
        });
        labelsPanel.add(backButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        label.setBounds(x, y, width, height);
        return label;
    }

    private JLabel createLabel(String text, int x, int y, int width, int height, Font font) {
        JLabel label = createLabel(text, x, y, width, height);
        label.setFont(font);
        return label;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Profile::new);
    }
}
