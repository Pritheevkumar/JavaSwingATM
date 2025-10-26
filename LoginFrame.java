import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {
    private final JTextField cardField = new JTextField(15);
    private final JPasswordField pinField = new JPasswordField(15);
    private final Account account;

    public LoginFrame(Account account) {
        super("ATM - Login");
        this.account = account;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildUI();
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void buildUI() {
        JPanel form = new JPanel(new GridBagLayout());
        form.setOpaque(false);
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(8, 8, 8, 8);
        gc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Welcome to ATM");
        title.setFont(Main.BOLD_16);

        JLabel cardLbl = new JLabel("Card Number:");
        cardLbl.setFont(Main.BOLD_14);
        JLabel pinLbl = new JLabel("PIN:");
        pinLbl.setFont(Main.BOLD_14);

        cardField.setFont(Main.PLAIN_14);
        pinField.setFont(Main.PLAIN_14);

        JButton loginBtn = new JButton("Login");
        Main.styleButton(loginBtn);
        loginBtn.addActionListener(this::onLogin);

        JButton exitBtn = new JButton("Exit");
        Main.styleButton(exitBtn);
        exitBtn.addActionListener(e -> System.exit(0));

        gc.gridx = 0; gc.gridy = 0; gc.gridwidth = 2;
        form.add(title, gc);

        gc.gridwidth = 1;
        gc.gridx = 0; gc.gridy = 1;
        form.add(cardLbl, gc);
        gc.gridx = 1;
        form.add(cardField, gc);

        gc.gridx = 0; gc.gridy = 2;
        form.add(pinLbl, gc);
        gc.gridx = 1;
        form.add(pinField, gc);

        JPanel buttons = new JPanel();
        buttons.setOpaque(false);
        buttons.add(loginBtn);
        buttons.add(exitBtn);

        gc.gridx = 0; gc.gridy = 3; gc.gridwidth = 2;
        form.add(buttons, gc);

        setContentPane(Main.padded(form));
        getContentPane().setBackground(Main.BG);
    }

    private void onLogin(ActionEvent e) {
        String card = cardField.getText().trim();
        String pin = new String(pinField.getPassword()).trim();

        if (card.equals(account.getCardNumber()) && pin.equals(account.getPin())) {
            SwingUtilities.invokeLater(() -> {
                MenuFrame menu = new MenuFrame(account);
                menu.setVisible(true);
            });
            dispose();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Invalid Card Number or PIN.\nTry card=123456, PIN=1234",
                    "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }
}
