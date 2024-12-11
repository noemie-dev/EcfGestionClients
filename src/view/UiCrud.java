package view;

import javax.swing.*;
import java.awt.event.*;

public class UiCrud extends JFrame {
    private JPanel contentPane;
    private JButton retourButton;
    private JButton quitterButton;
    private JPanel crudLabelPanel;
    private JPanel crudTextePanel;
    private JTextField idTextField;
    private JTextField raisonSocTextField;
    private JTextField nbRueTextField;
    private JTextField codePostalTextField;
    private JTextField villeTextField;
    private JTextField telephoneTextField;
    private JTextField emailTextField;
    private JTextField chiffreAffairetextField;
    private JTextField nbEmployesTextField;
    private JButton crudValiderButton;
    private JTextArea CommTextArea;
    private JLabel emptyLabel;
    private JLabel commLabel;
    private JLabel idLabel;
    private JLabel raisonSocLabel;
    private JLabel adresseLabel;
    private JLabel nbRueLabel;
    private JTextField nomRueTextField;
    private JLabel nomRueLabel;
    private JLabel codePostalLabel;
    private JLabel villeLabel;
    private JLabel telephoneLabel;
    private JLabel mailLabel;
    private JTabbedPane titreCrudPanel;
    private JLabel chiffreAffairesLabel;
    private JLabel nombreEmployesLabel;
    private JTextField dateProspectTextField;
    private JTextField interetProspectTextField;
    private JLabel interetProspectLabel;
    private JLabel dateProspectLabel;

    public UiCrud() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(retourButton);

        retourButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        quitterButton.addActionListener(new ActionListener() {
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
