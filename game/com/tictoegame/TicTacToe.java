package com.tictoegame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToe extends JFrame implements ActionListener {
    private JLabel heading;
    private JLabel time;
    // button
    private JButton[] btns = new JButton[9];
    int gameChances[] = { 2, 2, 2, 2, 2, 2, 2, 2, 2 };
    int activePlayer = 1;
    // making Array of winning position
    int winposition[][] = {
            { 0, 1, 2 },
            { 3, 4, 5 },
            { 6, 7, 8 },
            { 0, 3, 6 },
            { 1, 4, 7 },
            { 2, 5, 8 },
            { 0, 4, 8 },
            { 2, 4, 6 }
    };
    int winner = 2;
    boolean gameover = false;

    // central pannel
    private JPanel mainPanel;
    // clock for label time
    private SimpleDateFormat clock;
    // font deaclaration
    private static final String FONT_NAME = "Times New Roman";
    private static final int FONT_SIZE = 35;
    private static final int FONT_STYLE = Font.BOLD;
    private Font font = new Font(FONT_NAME, FONT_STYLE, FONT_SIZE);

    TicTacToe() {
        // creating window
        System.out.println("making window for game");
        setSize(800, 800);
        setTitle("Tic Tac Toe");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createGUI();
        setVisible(true);
        // set icon to title
        ImageIcon icon = new ImageIcon("com/tictoegame/img/tic-tac-toe.png");
        this.setIconImage(icon.getImage());
    }

    // creating gui
    public void createGUI() {
        this.setLayout(new BorderLayout());
        // heading
        this.add(heading = new JLabel("Tic Tac Toe"), BorderLayout.NORTH);
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setFont(font);
        heading.setForeground(Color.white);
        this.getContentPane().setBackground(Color.decode("#2196f3"));
        // footer time
        this.add(time = new JLabel("Time: "), BorderLayout.SOUTH);
        time.setHorizontalAlignment(JLabel.CENTER);
        time.setFont(font);
        time.setForeground(Color.white);
        // clock
        clock = new SimpleDateFormat("HH:mm:ss a");
        // set time
        Thread t = new Thread() {
            public void run() {
                while (true) {
                    time.setText(clock.format(System.currentTimeMillis()));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }

                }
            }

        };
        t.start();
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 3));

        // buttons
        for (int i = 1; i <= 9; i++) {
            JButton btn = new JButton();
            btn.setFont(font);
            btn.setBackground(Color.decode("#90caf9"));

            mainPanel.add(btn);
            btns[i - 1] = btn;
            btn.addActionListener(this);
            btn.setName(String.valueOf(i - 1));

        }
        this.add(mainPanel, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method
        JButton currentButton = (JButton) e.getSource();
        String name = currentButton.getName();
        int n = Integer.parseInt(name);
        if (gameover) {
            JOptionPane.showMessageDialog(this, "game Over...");
            return;
        }
        if (gameChances[n] == 2) {
            if (activePlayer == 1) {
                ImageIcon icon = new ImageIcon("com/tictoegame/img/o.png");
                int maxWidth = currentButton.getWidth();
                int maxHeight = currentButton.getHeight();

                Image image = icon.getImage().getScaledInstance(maxWidth, maxHeight, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(image);
                currentButton.setIcon(resizedIcon);
                gameChances[n] = activePlayer;
                activePlayer = 0;
            } else {
                ImageIcon icon = new ImageIcon("com/tictoegame/img/cross.png");
                int maxWidth = currentButton.getWidth();
                int maxHeight = currentButton.getHeight();

                Image image = icon.getImage().getScaledInstance(maxWidth, maxHeight, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(image);
                currentButton.setIcon(resizedIcon);
                gameChances[n] = activePlayer;
                activePlayer = 1;
            }
            // find the winner
            for (int temp[] : winposition) {
                if ((gameChances[temp[0]] == gameChances[temp[1]]) && (gameChances[temp[1]] == gameChances[temp[2]])
                        && (gameChances[temp[1]] != 2)) {
                    gameover = true;
                    winner = gameChances[temp[0]];
                    JOptionPane.showMessageDialog(null, "Player " + winner + " Won");
                    // reset game when player is winner
                    int i = JOptionPane.showConfirmDialog(this, "Do you want to play more");
                    if (i == 0) {
                        this.dispose();
                        TicTacToe ticTacToe = new TicTacToe();
                        ticTacToe.setVisible(true);
                    } else {
                        System.exit(536);
                        ;
                    }

                }
        

            }
            // draw logic
            int count = 0;
            for (int x : gameChances) {
                if (x == 2) {
                    count++;
                    break;
                }

            }
            if (count == 0 && gameover == false) {
                JOptionPane.showMessageDialog(null, "Draw");
                int i = JOptionPane.showConfirmDialog(this, "play more..");
                if (i == 0) {
                    this.dispose();
                    TicTacToe ticTacToe = new TicTacToe();
                    ticTacToe.setVisible(true);
                } else {
                    System.exit(536);
                    ;
                }

            }

        } else {
            JOptionPane.showMessageDialog(this, "Already Occupied");
        }
        // cheack win

        // if player win

        // System.out.println("clicked");
        // throw new UnsupportedOperationException("Unimplemented method
        // 'actionPerformed'");
    }
}
