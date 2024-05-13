import javax.swing.*;

public class DepositGUI extends JFrame {
    private CryptoWalletGUI cryptoWalletGUI; // Reference to CryptoWalletGUI

    public DepositGUI(CryptoWalletGUI cryptoWalletGUI) {
        this.cryptoWalletGUI = cryptoWalletGUI; // Assign the reference

        setTitle("Deposit Money");
        setBounds(200, 100, 400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel cardNumberLabel = new JLabel("Card Number:");
        cardNumberLabel.setBounds(20, 20, 120, 30);
        add(cardNumberLabel);

        JLabel expiryDateLabel = new JLabel("Expiry Date (MM/YY):");
        expiryDateLabel.setBounds(20, 60, 150, 30);
        add(expiryDateLabel);

        JLabel amountLabel = new JLabel("Amount ($):");
        amountLabel.setBounds(20, 100, 100, 30);
        add(amountLabel);

        JLabel pinLabel = new JLabel("PIN:");
        pinLabel.setBounds(20, 140, 100, 30);
        add(pinLabel);

        JTextField cardNumberField = new JTextField();
        cardNumberField.setBounds(150, 20, 200, 30);
        add(cardNumberField);

        JTextField expiryDateField = new JTextField();
        expiryDateField.setBounds(150, 60, 100, 30);
        add(expiryDateField);

        JTextField amountField = new JTextField();
        amountField.setBounds(150, 100, 100, 30);
        add(amountField);

        JPasswordField pinField = new JPasswordField();
        pinField.setBounds(150, 140, 100, 30);
        add(pinField);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(40, 200, 100, 30);
        depositButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                cryptoWalletGUI.updateBalance(amount);
                dispose(); 
				cryptoWalletGUI.setVisible(true);// Close DepositGUI after deposit
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(depositButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(160, 200, 100, 30);
        backButton.addActionListener(e -> {
            dispose();
            cryptoWalletGUI.setVisible(true);
        });
        add(backButton);

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(280, 200, 100, 30);
        clearButton.addActionListener(e -> {
            cardNumberField.setText("");
            expiryDateField.setText("");
            amountField.setText("");
            pinField.setText("");
        });
        add(clearButton);

        setVisible(true);
    }
}
