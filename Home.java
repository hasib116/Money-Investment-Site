import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    private JLabel EURLabel, GBRLabel, JPYLabel,boLabel, soLabel;
    private JButton EURButton, GBRButton, JPYButton;
    private ImageIcon img;
    private JLabel imageLabel;
    private static final int BUTTON_WIDTH = 100;
    private static final int BUTTON_HEIGHT = 30;
    private static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 14);

    public Home() {
        setTitle("Home Page");
        setBounds(200, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

	    
		img = new ImageIcon(Login.class.getResource("home.jpg")); 
        imageLabel = new JLabel(img);
        imageLabel.setBounds(300, 70, 490, 350);
        add(imageLabel);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Create buttons
        JButton profileButton = createButton("Profile");
        JButton homeButton = createButton("Home");
        JButton convertButton = createButton("Convert");
        JButton walletButton = createButton("Wallet");

        // Add buttons to the panel
        buttonPanel.add(profileButton);
        buttonPanel.add(homeButton);
        buttonPanel.add(convertButton);
        buttonPanel.add(walletButton);

        // Add button panel to the frame's north position
        add(buttonPanel, BorderLayout.NORTH);

        // Create a panel for labels and buttons
        JPanel panel = new JPanel();
        panel.setLayout(null); // Use absolute layout
		
		
		soLabel = new JLabel("Currency");
        soLabel.setBounds(50, 60, 200, 30);
		soLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        panel.add(soLabel);
		
		boLabel = new JLabel("Profit");
        boLabel.setBounds(200, 60, 200, 30);
		boLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        panel.add(boLabel);

        // Create labels
        EURLabel = new JLabel("EUR---------------");
        EURLabel.setBounds(50, 100, 200, 30);
        panel.add(EURLabel);

        GBRLabel = new JLabel("GBR---------------");
        GBRLabel.setBounds(50, 170, 200, 30);
        panel.add(GBRLabel);

        JPYLabel = new JLabel("JPY----------------");
        JPYLabel.setBounds(50, 240, 200, 30);
        panel.add(JPYLabel);

        // Create buttons
        EURButton = new JButton("0.52%");
        EURButton.setBounds(200, 100, 90, 30);
		EURButton.setBackground(Color.GREEN);
        panel.add(EURButton);
        EURButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action for EUR button
            }
        });

        GBRButton = new JButton("1.25%");
        GBRButton.setBounds(200, 170,90 , 30);
		GBRButton.setBackground(Color.GREEN);
        panel.add(GBRButton);
        GBRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action for GBR button
            }
        });

        JPYButton = new JButton("-0.92%");
        JPYButton.setBounds(200, 240, 90, 30);
		JPYButton.setBackground(Color.RED);
        panel.add(JPYButton);
        JPYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action for JPY button
            }
        });

        // Add panel to the frame's center position
        add(panel, BorderLayout.CENTER);

        // ActionListener for buttons
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Profile log = new Profile();
                log.setVisible(true);
            }
        });
        homeButton.addActionListener(new ButtonActionListener("Oh this is,  Home!"));
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CurrencyConverter log = new CurrencyConverter();
                log.setVisible(true);
            }
        });

        walletButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CryptoWalletGUI log = new CryptoWalletGUI();
                log.setVisible(true);
            }
        });

        setVisible(true);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button.setFont(BUTTON_FONT);
        return button;
    }

    private class ButtonActionListener implements ActionListener {
        private String message;

        public ButtonActionListener(String message) {
            this.message = message;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, message);
        }
    }

    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Home());
    }
}
