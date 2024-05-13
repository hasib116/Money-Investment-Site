import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyConverter extends JFrame implements ActionListener {
    private JLabel inputLabel;
    private JLabel outputLabel;
    private JTextField inputField;
    private JLabel resultLabel;
    private JButton convertButton, backButton;
    private JComboBox<String> fromComboBox;
    private JComboBox<String> toComboBox;
    private static final int BUTTON_WIDTH = 100;
    private static final int BUTTON_HEIGHT = 30;
    private static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 14);

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null); // Use null layout

        // Set bounds for components
        inputLabel = new JLabel("Amount:");
        inputLabel.setBounds(100, 150, 100, 30);
        panel.add(inputLabel);

        inputField = new JTextField();
        inputField.setBounds(260, 150, 100, 30);
        panel.add(inputField);

        fromComboBox = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "JPY", "CAD", "AUD", "CHF", "CNY", "INR", "BDT"});
        fromComboBox.setBounds(100, 200, 100, 30);
        panel.add(fromComboBox);

        toComboBox = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "JPY", "CAD", "AUD", "CHF", "CNY", "INR", "BDT"});
        toComboBox.setBounds(260, 200, 100, 30);
        panel.add(toComboBox);

        convertButton = new JButton("Convert");
        convertButton.setBounds(100, 250, 100, 30);
        convertButton.addActionListener(this);
        panel.add(convertButton);

        backButton = new JButton("Back");
        backButton.setBounds(260, 250, 100, 30);
        backButton.addActionListener(this);
        panel.add(backButton);

        outputLabel = new JLabel("Result:");
        outputLabel.setBounds(100, 300, 100, 30);
        panel.add(outputLabel);

        resultLabel = new JLabel();
        resultLabel.setBounds(260, 300, 200, 30);
        panel.add(resultLabel);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertButton) {
            try {
                double amount = Double.parseDouble(inputField.getText());
                String fromCurrency = fromComboBox.getSelectedItem().toString();
                String toCurrency = toComboBox.getSelectedItem().toString();
                double result = convertCurrency(amount, fromCurrency, toCurrency);
                resultLabel.setText(String.format("%.2f %s = %.2f %s", amount, fromCurrency, result, toCurrency));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == backButton) {
            // Add functionality for back button (for example, go back to previous page)
            // For now, let's just close the window
            dispose(); // Close the window
			new Home().setVisible(true);
        }
    }

    private double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        double rate = getConversionRate(fromCurrency, toCurrency);
        return amount * rate;
    }

    private double getConversionRate(String fromCurrency, String toCurrency) {
        // Conversion rates matrix
        double[][] conversionMatrix = {
                {1.0, 0.93, 0.80, 153.17, 1.37, 1.52, 0.91, 7.24, 83.41, 109.2}, // USD
                {1.07, 1.0, 0.87, 163.49, 1.47, 1.63, 0.98, 7.6, 89.62, 117.4}, // EUR
                {1.26, 1.17, 1.0, 192.09, 1.74, 1.91, 1.14, 9.03, 104.73, 137.4}, // GBP
                {0.0091, 0.0081, 0.0070, 1.0, 0.0115, 0.013, 0.0082, 0.058, 0.66, 0.00091}, // JPY
                {0.79, 0.70, 0.61, 87.36, 1.0, 1.13, 0.71, 5.01, 56.92, 0.0079}, // CAD
                {0.69, 0.61, 0.53, 75.42, 0.88, 1.0, 0.63, 4.47, 50.87, 0.0069}, // AUD
                {1.10, 0.97, 0.84, 119.04, 1.37, 1.55, 1.0, 7.05, 80.11, 0.011}, // CHF
                {0.16, 0.14, 0.12, 16.82, 0.19, 0.21, 0.13, 1.0, 11.36, 0.0016}, // CNY
                {0.014, 0.012, 0.011, 1.59, 0.018, 0.02, 0.013, 0.091, 1.0, 0.00014}, // INR
                {0.0091, 0.0085, 0.0073, 1.14, 0.012, 0.014, 0.0083, 0.066, 0.76, 1.0} // BDT
        };

        int fromIndex = getIndex(fromCurrency);
        int toIndex = getIndex(toCurrency);
        if (fromIndex != -1 && toIndex != -1) {
            return conversionMatrix[fromIndex][toIndex];
        }
        return 1.0;
    }

    private int getIndex(String currency) {
        String[] currencies = {"USD", "EUR", "GBP", "JPY", "CAD", "AUD", "CHF", "CNY", "INR", "BDT"};
        for (int i = 0; i < currencies.length; i++) {
            if (currency.equals(currencies[i])) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CurrencyConverter();
            }
        });
    }
}
