package com.lieeber.copyimage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AlertDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel lblabel;

    public AlertDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Mvp Create Helper");
        setContentPane(contentPane);
        setSize(640, 360);
        setLocationRelativeTo(null);


        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        ImageIcon imageIcon = new ImageIcon("/Users/lieeber/Downloads/aaa/drawable-xhdpi/treiofjiodjgfghj.png");
        lblabel.setIcon(imageIcon);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        AlertDialog dialog = new AlertDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
