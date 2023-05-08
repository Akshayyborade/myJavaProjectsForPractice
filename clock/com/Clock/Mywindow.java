package com.Clock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Mywindow extends JFrame {
    private JLabel datelabel;
    private JLabel clocklabel;
    private JLabel dayLabel;
    SimpleDateFormat dateFormat;
    SimpleDateFormat clockFormat;
    SimpleDateFormat dayFormat;
    String day;
    String date;
    String clock;
    private Font fontday = new Font("", Font.BOLD, 60);
    private Font fontdate = new Font("", Font.BOLD, 40);
    private Font fontclock = new Font("", Font.ITALIC, 30);

    Mywindow() {

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setTitle("My Clock");
        super.setSize(500, 500);
        super.setLocation(400, 100);
        gui();
        startClock();

        super.setVisible(true);

    }

    public void gui() {
        dayLabel = new JLabel("day" , JLabel.CENTER);
        datelabel = new JLabel("My clock",JLabel.CENTER);
        clocklabel = new JLabel("Clock", JLabel.CENTER);

        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("dd MMMMM yyyy");
        clockFormat = new SimpleDateFormat("HH:mm:ss a");

        datelabel.setFont(fontdate);
        clocklabel.setFont(fontclock);
        dayLabel.setFont(fontday);
        this.setLayout(new GridLayout(3, 1));

        this.add(dayLabel);
        this.add(datelabel);
        this.add(clocklabel);
    }

    public void startClock() {
        Timer timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                day = dayFormat.format(Calendar.getInstance().getTime());
                dayLabel.setText(day);
                clock = clockFormat.format(Calendar.getInstance().getTime());
                clocklabel.setText(clock);
                date = dateFormat.format(Calendar.getInstance().getTime());
                datelabel.setText(date);

            }
        });
        timer.start();
    }

}
