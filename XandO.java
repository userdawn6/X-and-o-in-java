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
    class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (gameWon) return;

            JButton buttonClicked = (JButton) e.getSource();

            if (buttonClicked.getText().equals("")) {
                if (player1_turn) {
                    buttonClicked.setText("X");
                    buttonClicked.setForeground(Color.RED);
                } else {
                    buttonClicked.setText("O");
                    buttonClicked.setForeground(Color.BLUE);
                }
                player1_turn = !player1_turn;
                textlabel.setText(player1_turn ? "Player 1's Turn (X)" : "Player 2's Turn (O)");
                checkForWin();
            }
        }
    }

    void checkForWin() {
        for (int[] combination : winCombinations) {
            if (buttons[combination[0]].getText().equals(buttons[combination[1]].getText()) &&
                    buttons[combination[1]].getText().equals(buttons[combination[2]].getText()) &&
                    !buttons[combination[0]].getText().equals("")) {

                String winner = buttons[combination[0]].getText();
                textlabel.setText(winner + " wins!");
                JOptionPane.showMessageDialog(frame, winner + " wins!");
                disableButtons();
                gameWon = true;
                promptPlayAgain();
                return;
            }
        }

        boolean tie = true;
        for (JButton button : buttons) {
            if (button.getText().equals("")) {
                tie = false;
                break;
            }
        }
        if (tie) {
            textlabel.setText("It's a tie!");
            JOptionPane.showMessageDialog(frame, "It's a tie!");
            disableButtons();
            gameWon = true;
            promptPlayAgain();
        }
    }

    void disableButtons() {
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
    }

    void resetBoard() {
        for (JButton button : buttons) {
            button.setText("");
            button.setEnabled(true);
        }
        player1_turn = true;
        textlabel.setText("X and O");
        gameWon = false;
    }

    void promptPlayAgain() {
        int response = JOptionPane.showConfirmDialog(frame, "Play again?", "X and O", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            resetBoard();
        } else {
            System.exit(0);
        }
    }
}
