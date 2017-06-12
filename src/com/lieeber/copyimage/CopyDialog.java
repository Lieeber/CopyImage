package com.lieeber.copyimage;

import javax.swing.*;
import java.awt.event.*;

public class CopyDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField lbTextField;


    public interface DialogCallback {
        void onOk(String text);
    }

    //    private DialogCallback callback;
    public CopyDialog(DialogCallback callback) {
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
                if (callback != null) {
                    String text = lbTextField.getText().trim();
                    System.out.println(text);
                    callback.onOk(text);
                }
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
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

//    public static void main(String[] args) {
//        CopyDialog dialog = new CopyDialog();
//        dialog.pack();
//        dialog.setVisible(true);
//        System.exit(0);
//    }
}
