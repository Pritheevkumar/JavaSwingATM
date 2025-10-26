import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.format.DateTimeFormatter;

public class TransactionHistoryFrame extends JFrame {
    private final Account account;
    private final JFrame parent;

    public TransactionHistoryFrame(JFrame parent, Account account) {
        super("ATM - Transaction History");
        this.parent = parent;
        this.account = account;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        buildUI();
        setSize(560, 360);
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    private void buildUI() {
        String[] cols = {"Type", "Amount ($)", "Timestamp"};
        DefaultTableModel model = new DefaultTableModel(cols, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (Transaction t : account.getTransactions()) {
            model.addRow(new Object[]{
                    t.getType(),
                    String.format("%.2f", t.getAmount()),
                    t.getTimestamp().format(fmt)
            });
        }

        JTable table = new JTable(model);
        table.setFont(Main.PLAIN_14);
        table.getTableHeader().setFont(Main.BOLD_14);
        JScrollPane sp = new JScrollPane(table);

        JButton close = new JButton("Close");
        Main.styleButton(close);
        close.addActionListener(e -> dispose());

        JPanel south = new JPanel();
        south.setOpaque(false);
        south.add(close);

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setOpaque(false);
        wrapper.add(sp, BorderLayout.CENTER);
        wrapper.add(south, BorderLayout.SOUTH);

        setContentPane(Main.padded(wrapper));
        getContentPane().setBackground(Main.BG);
    }
}
