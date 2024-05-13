import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MoneyTransferPage extends JFrame {
    private JLabel senderLabel, receiverLabel, amountLabel, messageLabel;
    private JTextField senderField, receiverField, amountField;
    private JButton transferButton, backButton;

    public MoneyTransferPage(CryptoWalletGUI cryptoWalletGUI) {
        setTitle("Money Transfer");
        setBounds(200, 100, 400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        senderLabel = new JLabel("Sender Account No:");
        senderLabel.setBounds(50, 50, 200, 30);
        panel.add(senderLabel);

        senderField = new JTextField();
        senderField.setBounds(250, 50, 120, 30);
        panel.add(senderField);

        receiverLabel = new JLabel("Receiver Account No:");
        receiverLabel.setBounds(50, 100, 200, 30);
        panel.add(receiverLabel);

        receiverField = new JTextField();
        receiverField.setBounds(250, 100, 120, 30);
        panel.add(receiverField);

        amountLabel = new JLabel("Amount to Transfer:");
        amountLabel.setBounds(50, 150, 200, 30);
        panel.add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(250, 150, 120, 30);
        panel.add(amountField);

        transferButton = new JButton("Transfer");
        transferButton.setBounds(100, 200, 100, 30);
        transferButton.addActionListener(e -> transfer());
        panel.add(transferButton);

        backButton = new JButton("Back");
        backButton.setBounds(220, 200, 100, 30);
        backButton.addActionListener(e -> {
            dispose();
            cryptoWalletGUI.setVisible(true);
        });
        panel.add(backButton);

        messageLabel = new JLabel();
        messageLabel.setBounds(50, 250, 300, 30);
        panel.add(messageLabel);

        add(panel);
        setVisible(true);
    }

    private void transfer() {
        String sender = senderField.getText();
        String receiver = receiverField.getText();
        String amountStr = amountField.getText();
        try {
            double amount = Double.parseDouble(amountStr);
            // Transfer logic goes here
            messageLabel.setText("Transfer of $" + amount + " from " + sender + " to " + receiver + " successful.");
            senderField.setText("");
            receiverField.setText("");
            amountField.setText("");
        } catch (NumberFormatException ex) {
            messageLabel.setText("Invalid amount!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Assuming you have an instance of CryptoWalletGUI already created
            CryptoWalletGUI cryptoWalletGUI = new CryptoWalletGUI();
            new MoneyTransferPage(cryptoWalletGUI);
        });
    }
}
