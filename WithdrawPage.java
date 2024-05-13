import javax.swing.*;

public class WithdrawPage extends JFrame {
    private CryptoWalletGUI cryptoWalletGUI; // Reference to CryptoWalletGUI

    public WithdrawPage(CryptoWalletGUI cryptoWalletGUI) {
        this.cryptoWalletGUI = cryptoWalletGUI; // Assign the reference

        setTitle("Withdraw");
        setBounds(200, 100, 600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel amountLabel = new JLabel("Enter Amount to Withdraw:");
        amountLabel.setBounds(50, 50, 200, 30);
        add(amountLabel);

        JTextField amountField = new JTextField();
        amountField.setBounds(250, 50, 150, 30);
        add(amountField);

        JLabel acLabel = new JLabel("Enter Account No:");
        acLabel.setBounds(50, 110, 200, 30);
        add(acLabel);

        JTextField acnoField = new JTextField();
        acnoField.setBounds(250, 110, 150, 30);
        add(acnoField);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(200, 170, 110, 30);
        withdrawButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                cryptoWalletGUI.updateBalance(-amount); // Update balance
                dispose();
                 cryptoWalletGUI.setVisible(true);				// Close WithdrawPage after withdrawal
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(withdrawButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(200, 230, 110, 30);
        backButton.addActionListener(e -> {
            dispose();
            cryptoWalletGUI.setVisible(true);
        });
        add(backButton);

        JLabel messageLabel = new JLabel();
        messageLabel.setBounds(50, 150, 300, 30);
        add(messageLabel);

        setVisible(true);
    }
}
