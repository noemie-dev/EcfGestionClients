package view;

import javax.swing.*;

public class UIAccueil extends JFrame {
    private JPanel contentPane;
    private JButton retourButton;
    private JButton quitterButton;
    private JPanel clientProspectPanel;
    private JPanel crudPanel;
    private JPanel modifPanel;
    private JButton clientButton;
    private JButton prospectButton;
    private JLabel clientProspectButton;
    private JButton creerButton;
    private JButton modifierButton;
    private JButton supprimerButton;
    private JButton afficherListeButton;
    private JComboBox comboBox1;
    private JButton validerButton;

    public UIAccueil() {
        initComponents();
    }

   /*     retourButton.addActionListener(new ActionListener() {
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
*/
    private void initComponents() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(retourButton);
        this.setSize(600, 600);
        crudPanel.setVisible(false);
        modifPanel.setVisible(false);
    }
}
