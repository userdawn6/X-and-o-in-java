import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XandO {

    JFrame frame = new JFrame();
    JPanel textpanel = new JPanel();
    JLabel textlabel = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn = true;
    boolean gameWon = false;

    int[][] winCombinations = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };
public XandO() {
        drawUI();
    }

    void drawUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 650);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        textlabel.setBackground(Color.black);
        textlabel.setForeground(Color.gray);
        textlabel.setFont(new Font("Arial", Font.BOLD, 50));
        textlabel.setHorizontalAlignment(JLabel.CENTER);
        textlabel.setText("X and O");
        textlabel.setOpaque(true);

        textpanel.setLayout(new BorderLayout());
        textpanel.add(textlabel, BorderLayout.CENTER);
        frame.add(textpanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(new ButtonClickListener());
            buttonPanel.add(buttons[i]);
        }
        frame.add(buttonPanel);

        frame.setVisible(true);
    }
