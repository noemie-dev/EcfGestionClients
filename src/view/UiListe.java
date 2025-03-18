package view;


import entities.Client;
import entities.Prospect;
import utilities.ChoixClientProspect;

import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


import static utilities.Regex.DATE_FORMATTER;

/** interface affichant la liste des clients et des prospects, non modifiable
 */
public class UiListe extends JFrame {
    private JPanel contentPane;
    private JButton retourButton;
    private JButton quitterButton;
    private JTable table;

    public UiListe(ChoixClientProspect choixClientProspect) {
        setContentPane(contentPane);
        //    setModal(true);
        getRootPane().setDefaultButton(retourButton);
        initComponent();
        listeners();
    }


    private void initComponent() {
        this.setSize(900, 900);
    }

    private void listeners() {
        retourButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Voulez allez être redirigé vers l'accueil");
                new UiAccueil2().setVisible(true);
                dispose();
            }
        });

        quitterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Fermeture de l'application");
                System.exit(0);
            }
        });
    }


}

