package com.cnicg.lemon.demo.moshi.CommandMoshi;

import com.cnicg.lemon.demo.moshi.CommandMoshi.command.Command;
import com.cnicg.lemon.demo.moshi.CommandMoshi.command.MacroCommand;
import com.cnicg.lemon.demo.moshi.CommandMoshi.draw.DrawCanvas;
import com.cnicg.lemon.demo.moshi.CommandMoshi.draw.DrawCommand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener {

    private MacroCommand history = new MacroCommand();
    private DrawCanvas canvas = new DrawCanvas(1000, 1000, history);
    private JButton clearButton = new JButton("clear");

    public Main(String title){
        super(title);

        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        clearButton.addActionListener(this);

        Box button_box = new Box(BoxLayout.X_AXIS);
        button_box.add(clearButton);
        Box main_box = new Box(BoxLayout.Y_AXIS);
        main_box.add(button_box);
        main_box.add(clearButton);
        getContentPane().add(main_box);

        pack();
        show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() ==  clearButton){
            history.clear();
            canvas.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Command command = new DrawCommand(canvas, e.getPoint());
        history.append(command);
        command.execute();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public static void main(String[] args) {
        new Main("Command Simple");
    }



    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
