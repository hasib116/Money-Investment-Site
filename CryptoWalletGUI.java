import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class CryptoWalletGUI extends JFrame implements ActionListener {

    private JLabel userIdLabel;
    private JLabel userLevelLabel;
    private JLabel userTypeLabel;
    private JLabel followingLabel;
    private JLabel followersLabel;
    private JLabel balanceLabel;
    private JLabel todayPnlLabel;
    private JLabel walletViewLabel;
    private JTextField amountField;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton transferButton;
    private JButton moreButton;
    private JTextArea assetArea;
    private double balance = 1000.0;

    public CryptoWalletGUI() {
        setTitle("Wallet");
        setBounds(200, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);

        userIdLabel = new JLabel("User ID: 865468941");
        userLevelLabel = new JLabel("Regular User");
        userTypeLabel = new JLabel("Home");
        followingLabel = new JLabel("Following: 0");
        followersLabel = new JLabel("Followers: 0");
        balanceLabel = new JLabel("Balance:"+balance);
        balanceLabel.setFont(new Font("Sans Serif", Font.BOLD, 16));
        todayPnlLabel = new JLabel("Today's Profit: $0.00 (0.00%)");
        walletViewLabel = new JLabel("Wallet View");
        walletViewLabel.setFont(new Font("Sans Serif", Font.BOLD, 14));

        amountField = new JTextField(10);

        depositButton = new JButton("Deposit");
        depositButton.addActionListener(this);
        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(this);
        transferButton = new JButton("Transfer");
        transferButton.addActionListener(this);

        moreButton = new JButton("Back");
        moreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                // Assuming Home is your main screen class
                new Home().setVisible(true);
            }
        });

        assetArea = new JTextArea();
        assetArea.setRows(10);
        assetArea.setColumns(30);

        JPanel topPanel = new JPanel(new GridLayout(2, 3));
        topPanel.add(userIdLabel);
        topPanel.add(userLevelLabel);
        topPanel.add(userTypeLabel);
        topPanel.add(followingLabel);
        topPanel.add(followersLabel);
        topPanel.add(moreButton);

        JPanel centerPanel = new JPanel(new GridLayout(3, 1));
        centerPanel.add(balanceLabel);
        centerPanel.add(todayPnlLabel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(transferButton);

        centerPanel.add(buttonPanel);

        JPanel assetPanel = new JPanel(new BorderLayout());
        assetPanel.setBorder(BorderFactory.createTitledBorder("My Assets"));
        assetPanel.add(walletViewLabel, BorderLayout.NORTH);
        assetPanel.add(new JScrollPane(assetArea), BorderLayout.CENTER);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, centerPanel, assetPanel);

        add(topPanel, BorderLayout.NORTH);
        add(splitPane, BorderLayout.CENTER);

        // Set frame properties
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depositButton) {
            // Implement deposit functionality here
            // For simplicity, I'm just displaying a message
            dispose();
            DepositGUI depositGUI = new DepositGUI(this);
            depositGUI.setVisible(true);
        } else if (e.getSource() == withdrawButton) {
            // Implement withdraw functionality here
            // For simplicity, I'm just displaying a message
            dispose();
            WithdrawPage withdrawPage = new WithdrawPage(this);
            withdrawPage.setVisible(true);
        } else if (e.getSource() == transferButton) {
            // Implement transfer functionality here
            // For simplicity, I'm just displaying a message
            dispose();
            MoneyTransferPage moneyTransferPage = new MoneyTransferPage(this);
            moneyTransferPage.setVisible(true);
        }
    }

    public void updateBalance(double amount) {
        balance += amount; // Update balance
        balanceLabel.setText(String.format("Balance: $%.2f", balance)); // Update balance label
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CryptoWalletGUI();
            }
        });
    }
}
