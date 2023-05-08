package com.Form;

import javax.swing.*;
import java.awt.*;

public class Formwindow extends JFrame {
    // instance variable requird to from objects
    private JLabel heading, name, password;
    private JPanel mainPanel;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton loginButton, resetButton;
    // for color and font
    Font font = new Font("", Font.BOLD, 35);

    // creating windowframe
    public Formwindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("My From");
        setSize(500, 600);
        setLocation(650, 100);
        setLayout(new BorderLayout());
        addComponents();
        setVisible(true);
    }

    // method to add components to form
    public void addComponents() {
        // creating object for each variable
        heading = new JLabel("Login Form");
        name = new JLabel("Name: ");
        password = new JLabel("Password: ");
        nameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        resetButton = new JButton("Reset");
        // set font to each object
        heading.setFont(font);
        name.setFont(font);
        password.setFont(font);
        nameField.setFont(font);
        passwordField.setFont(font);
        loginButton.setFont(font);
        resetButton.setFont(font);

        // add heading in mainwindow
        this.add(heading, BorderLayout.NORTH);
        // set heading to center
        heading.setHorizontalAlignment(JLabel.CENTER);
        // setting Layout
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 2));
        // add components to mainpanel
        mainPanel.add(name);
        mainPanel.add(nameField);
        mainPanel.add(password);
        mainPanel.add(passwordField);
        mainPanel.add(loginButton);
        mainPanel.add(resetButton);
        // add mainpanel to form
        this.add(mainPanel, BorderLayout.CENTER);
        

    }
    //create mordern gui
    
    
}
