package view;


import entities.Client;
import entities.Prospect;
import utilities.ChoixClientProspect;
import utilities.ChoixCrud;

import javax.swing.*;
import java.awt.event.*;


/** classe pour l'interface de l'accueil qui comporte 3 panels, pour les premières étapes de selection du type d'entités
 * du type d'actions,
 * et sur quelle entité faire l'action
 */
public class UiAccueil2 extends JFrame {
    private JPanel contentPane;
    private JButton retourButton;
    private JButton quitterButton;
    private JPanel accueilChoixPanel;
    private JPanel crudPanel;
    private JPanel modifSuppPanel;
    private JPanel accueilPanel;
    private JButton clientButton;
    private JButton prospectButton;
    private JButton creerButton;
    private JButton modifierButton;
    private JButton supprimerButton;
    private JButton afficherListeButton;
    private JComboBox comboBox1;
    private JButton validerButton;
    private JLabel infoModifSuppLabel;
    private JLabel classeChoisieLabel2;
    private JLabel actionChoisieLabel;
    private JLabel infoAccueilLabel;
    private JLabel infoActionCrudLabel;
    private JLabel classeChoisieLabel;
    private ChoixCrud choixCrud;
    private ChoixClientProspect choixClientProspect;

    // constructeur de l'interface
    public UiAccueil2() {
        initComponents(); // creer les composants à afficher
        listeners(); // comportement assigné aux boutons

    }


    private void initComponents() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(retourButton);
        this.setTitle("Accueil");
        this.setSize(900, 900);

    }

    private void listeners() {
        // boutons présents sur toutes les interfaces
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

        // boutons du premier panel accueil, choix entre client et prospect

        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choixClientProspect = ChoixClientProspect.CLIENT;
                classeChoisieLabel.setText("Gestion des Clients");
                crudPanel.setVisible(true);
                accueilChoixPanel.setVisible(false);

            }
        });

        prospectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choixClientProspect = ChoixClientProspect.PROSPECT;
                classeChoisieLabel.setText("Gestion des Prospects");
                crudPanel.setVisible(true);
                accueilChoixPanel.setVisible(false);

            }
        });


        afficherListeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UiListe(choixClientProspect).setVisible(true);
                dispose();
            }
        });


    }
}