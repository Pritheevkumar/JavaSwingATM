import javax.swing.*;
import java.awt.*;

public class Main {
    public static final Color BG = new Color(245, 245, 245);           // Light gray background
    public static final Color BTN = new Color(15, 46, 107);            // Dark blue button
    public static final Color BTN_TEXT = Color.WHITE;
    public static final Font  BOLD_16 = new Font("SansSerif", Font.BOLD, 16);
    public static final Font  BOLD_14 = new Font("SansSerif", Font.BOLD, 14);
    public static final Font  PLAIN_14 = new Font("SansSerif", Font.PLAIN, 14);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            applyNimbusLookAndFeel();
            // Seed one demo account with the required credentials
            Account demo = new Account("123456", "1234", 1000.00);
            LoginFrame login = new LoginFrame(demo);
            login.setVisible(true);
        });
    }

    public static void applyNimbusLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            // A few Nimbus UI defaults to keep the palette consistent
            UIManager.put("control", BG);
            UIManager.put("Panel.background", BG);
            UIManager.put("OptionPane.background", BG);
            UIManager.put("OptionPane.messageForeground", Color.DARK_GRAY);
            UIManager.put("Button.font", BOLD_14);
            UIManager.put("Label.font", BOLD_14);
        } catch (Exception ignored) {}
    }

    public static void styleButton(JButton b) {
        b.setBackground(BTN);
        b.setForeground(BTN_TEXT);
        b.setFocusPainted(false);
        b.setFont(BOLD_14);
        b.setBorder(BorderFactory.createEmptyBorder(10, 16, 10, 16));
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public static JPanel padded(Container c) {
        JPanel p = new JPanel(new BorderLayout());
        p.setOpaque(false);
        int pad = 16;
        p.setBorder(BorderFactory.createEmptyBorder(pad, pad, pad, pad));
        p.add(c, BorderLayout.CENTER);
        return p;
    }
}
