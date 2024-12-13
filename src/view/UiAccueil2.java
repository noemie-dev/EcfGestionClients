package view;

import entities.Client;
import entities.Prospect;
import utilities.ChoixClientProspect;
import utilities.ChoixCrud;

import javax.swing.*;
import java.awt.event.*;

import static entities.Clients.clients;
import static entities.Clients.getClients;
import static entities.Prospects.prospects;

public class UiAccueil2 extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
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

    public UiAccueil2() {
        initComponents();
        listeners();
        afficherPanels();

    }

       /* buttonOK.addActionListener(new ActionListener() {
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
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"ok");
                crudPanel.setVisible(true);
            }
        });*/




    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void initComponents() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);
        this.setTitle("Accueil");
        this.setSize(900,900);

    }

    private void listeners() {
        creerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UiCrud(choixClientProspect).setVisible(true);
            }
        });
        modifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choixCrud = ChoixCrud.MODIFIER;
                remplirCombobox();
               if (choixClientProspect==ChoixClientProspect.CLIENT) {
                   classeChoisieLabel2.setText("Gestion des Clients");
               }
               else classeChoisieLabel2.setText("Gestion des Prospects");
                actionChoisieLabel.setText("Modifier");
                modifSuppPanel.setVisible(true);

            }
        });
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               choixCrud = ChoixCrud.SUPPRIMER;
                remplirCombobox();
                if (choixClientProspect==ChoixClientProspect.CLIENT) {
                    classeChoisieLabel2.setText("Gestion des Clients");
                }
                else classeChoisieLabel2.setText("Gestion des Prospects");
                actionChoisieLabel.setText("Supprimer");
                modifSuppPanel.setVisible(true);

            }
        });
        afficherListeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"afficher");
            }
        });

        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choixClientProspect = ChoixClientProspect.CLIENT;
                classeChoisieLabel.setText("Gestion des Clients");
                crudPanel.setVisible(true);


            }
        });
        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               /* String recupAction = comboBox1.getSelectedItem().toString();
                if (recupAction == null || recupAction.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Selectionnez une société");
                    return;
                }*/
                int recupAction = comboBox1.getSelectedIndex();
                if (choixClientProspect==ChoixClientProspect.CLIENT) {
                    Client clientChoisi = clients.get(recupAction);
                    new UiCrud(choixCrud, clientChoisi).setVisible(true);
                }
                else if (choixClientProspect==ChoixClientProspect.PROSPECT) {
                    Prospect prospectChoisi = prospects.get(recupAction);
                    new UiCrud(choixCrud,prospectChoisi).setVisible(true);
                }


            }
        });
    }

    private void afficherPanels() {
        crudPanel.setVisible(false);
        modifSuppPanel.setVisible(false);
    }

    private void remplirCombobox() {
        if (choixClientProspect==ChoixClientProspect.CLIENT) {
            for (Client client : clients) {
                comboBox1.addItem(client.getRaisonSociale());
            }
        }
        else if (choixClientProspect==ChoixClientProspect.PROSPECT) {
            for (Prospect prospect : prospects) {
                comboBox1.addItem(prospect.getRaisonSociale());
            }
        }
    }


}
