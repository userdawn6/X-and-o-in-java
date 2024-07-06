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
