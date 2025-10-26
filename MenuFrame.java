import javax.swing.*;
import java.awt.*;

public class MenuFrame extends JFrame {
    private final Account account;

    public MenuFrame(Account account) {
        super("ATM - Main Menu");
        this.account = account;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildUI();
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void buildUI() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(10, 10, 10, 10);
        gc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Select an Option");
        title.setFont(Main.BOLD_16);

        JButton withdrawBtn = new JButton("Withdraw");
        JButton depositBtn = new JButton("Deposit");
        JButton balanceBtn = new JButton("Check Balance");
        JButton historyBtn = new JButton("View Transactions");
        JButton exitBtn = new JButton("Exit");

        Main.styleButton(withdrawBtn);
        Main.styleButton(depositBtn);
        Main.styleButton(balanceBtn);
        Main.styleButton(historyBtn);
        Main.styleButton(exitBtn);

        withdrawBtn.addActionListener(e -> new WithdrawFrame(this, account).setVisible(true));
        depositBtn.addActionListener(e -> new DepositFrame(this, account).setVisible(true));
        balanceBtn.addActionListener(e -> new BalanceFrame(this, account).setVisible(true));
        historyBtn.addActionListener(e -> new TransactionHistoryFrame(this, account).setVisible(true));
        exitBtn.addActionListener(e -> System.exit(0));

        gc.gridx = 0; gc.gridy = 0; gc.gridwidth = 2;
        panel.add(title, gc);

        gc.gridwidth = 1;
        gc.gridx = 0; gc.gridy = 1; panel.add(withdrawBtn, gc);
        gc.gridx = 1; gc.gridy = 1; panel.add(depositBtn, gc);
        gc.gridx = 0; gc.gridy = 2; panel.add(balanceBtn, gc);
        gc.gridx = 1; gc.gridy = 2; panel.add(historyBtn, gc);
        gc.gridx = 0; gc.gridy = 3; gc.gridwidth = 2; panel.add(exitBtn, gc);

        setContentPane(Main.padded(panel));
        getContentPane().setBackground(Main.BG);
    }
}
