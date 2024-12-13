package view;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UiListe extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable table;

    public UiListe() {
        setContentPane(contentPane);
        //    setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        initComponent();
        listeners();
        remplissageJTable();
    }


    private void initComponent() {
        this.setSize(600, 600);
    }

    private void listeners() {
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
    }


    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void remplissageJTable() {
        DefaultTableModel modelTable ;
        String[] entete;
        entete = new String[] {"1", "2", "3"};
        modelTable = new DefaultTableModel(new Object[][]{}, entete);
        modelTable.addRow(entete);
        for (int i= 1; i <4; i++)
            modelTable.addRow(new Object[] {
                    "d","b",
                    10,"b",
                    "f"
            });
        table.setModel(modelTable);
    }
}

