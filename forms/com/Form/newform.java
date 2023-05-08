package com.Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newform extends JFrame {
    // instance variables required for form objects
    private JLabel heading, nameLabel, passwordLabel;
    private JPanel mainPanel;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton loginButton, resetButton;

    // Creating the window frame
    public newform() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Login Form");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        addComponents();
        setVisible(true);
    }

    // Method to add components to the form
    public void addComponents() {
        // Creating and styling the heading label
        heading = new JLabel("Login Form");
        heading.setFont(new Font("", Font.BOLD, 35));

        // Creating labels for name and password fields
        nameLabel = new JLabel("Name:");
        passwordLabel = new JLabel("Password:");

        // Creating the text fields
        nameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        // Creating the login and reset buttons
        loginButton = new JButton("Login");
        resetButton = new JButton("Reset");

        // Creating a panel and setting its layout
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Adding components to the panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(loginButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(resetButton, gbc);

        // Adding the heading and main panel to the form
        add(heading, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        // Adding event listeners to the buttons
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredName = nameField.getText();
                String enteredPassword = new String(passwordField.getPassword());

                // Perform login validation here
                // ...

                // Display a dialog box with login information
                JOptionPane.showMessageDialog(newform.this,
                        "Name: " + enteredName + "\nPassword: " + enteredPassword,
                        "Login Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reset the form fields
                nameField.setText("");
                passwordField.setText("");
            }
        });
    }

    // Entry point for the program
   
}

