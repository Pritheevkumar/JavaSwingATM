import javax.swing.*;
import java.awt.*;

public class BalanceFrame extends JFrame {
    private final Account account;
    private final JFrame parent;
    private final JLabel balanceLbl = new JLabel();

    public BalanceFrame(JFrame parent, Account account) {
        super("ATM - Balance");
        this.parent = parent;
        this.account = account;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        buildUI();
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
        refreshBalance();
    }

    private void buildUI() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(10, 10, 10, 10);
        gc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Current Balance");
        title.setFont(Main.BOLD_16);
        balanceLbl.setFont(Main.BOLD_16);

        JButton refreshBtn = new JButton("Refresh");
        JButton closeBtn = new JButton("Close");
        Main.styleButton(refreshBtn);
        Main.styleButton(closeBtn);

        refreshBtn.addActionListener(e -> refreshBalance());
        closeBtn.addActionListener(e -> dispose());

        gc.gridx = 0; gc.gridy = 0; gc.gridwidth = 2; panel.add(title, gc);
        gc.gridx = 0; gc.gridy = 1; gc.gridwidth = 2; panel.add(balanceLbl, gc);
        gc.gridwidth = 1;
        gc.gridx = 0; gc.gridy = 2; panel.add(refreshBtn, gc);
        gc.gridx = 1; gc.gridy = 2; panel.add(closeBtn, gc);

        setContentPane(Main.padded(panel));
        getContentPane().setBackground(Main.BG);
    }

    private void refreshBalance() {
        balanceLbl.setText("$ " + String.format("%.2f", account.getBalance()));
    }
}
