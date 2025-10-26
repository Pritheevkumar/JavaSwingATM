import javax.swing.*;
import java.awt.*;

public class DepositFrame extends JFrame {
    private final Account account;
    private final JFrame parent;
    private final JTextField amountField = new JTextField(10);

    public DepositFrame(JFrame parent, Account account) {
        super("ATM - Deposit");
        this.parent = parent;
        this.account = account;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        buildUI();
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    private void buildUI() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(8, 8, 8, 8);
        gc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lbl = new JLabel("Enter amount to deposit:");
        lbl.setFont(Main.BOLD_14);
        amountField.setFont(Main.PLAIN_14);

        JButton depositBtn = new JButton("Deposit");
        JButton backBtn = new JButton("Back");
        Main.styleButton(depositBtn);
        Main.styleButton(backBtn);

        depositBtn.addActionListener(e -> onDeposit());
        backBtn.addActionListener(e -> dispose());

        gc.gridx = 0; gc.gridy = 0;
        panel.add(lbl, gc);
        gc.gridx = 1;
        panel.add(amountField, gc);

        gc.gridx = 0; gc.gridy = 1;
        panel.add(depositBtn, gc);
        gc.gridx = 1;
        panel.add(backBtn, gc);

        setContentPane(Main.padded(panel));
        getContentPane().setBackground(Main.BG);
    }

    private void onDeposit() {
        try {
            double amount = Double.parseDouble(amountField.getText().trim());
            if (amount <= 0) {
                JOptionPane.showMessageDialog(this, "Please enter an amount greater than zero.",
                        "Invalid Amount", JOptionPane.WARNING_MESSAGE);
                return;
            }
            boolean ok = account.deposit(amount);
            if (ok) {
                JOptionPane.showMessageDialog(this, "Deposit successful.\nNew Balance: $" + String.format("%.2f", account.getBalance()),
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                amountField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid amount.", "Failed", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
