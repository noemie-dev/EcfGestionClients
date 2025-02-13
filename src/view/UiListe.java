package view;


import entities.Client;
import entities.Prospect;
import utilities.ChoixClientProspect;

import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static entities.Clients.clients;
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
        remplissageJTable(choixClientProspect);
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

    private void remplissageJTable(ChoixClientProspect choixClientProspect) {
        DefaultTableModel modelTable ;
        String[] entete;
        List<Client> clients;
        List<Prospect> prospects;
        if (choixClientProspect == ChoixClientProspect.CLIENT) {
            entete = new String[]{"identifiant", "raison sociale", "nr rue", "nom rue",
                    "code postal", "ville", "telephone", "mail", "CA", "nbr employés"};
            modelTable = new DefaultTableModel(new Object[][]{}, entete);
            modelTable.addRow(entete);

            clients = Clients.triRaisonSociale();

            for (Client client : clients) {
                modelTable.addRow(new Object[]{
                        client.getId(),
                        client.getRaisonSociale(),
                        client.getAdresse().getRueNb(),
                        client.getAdresse().getRueNom(),
                        client.getAdresse().getCodePostal(),
                        client.getAdresse().getVille(),
                        client.getTelephone(),
                        client.getEmail(),
                        client.getChiffreAffaires(),
                        client.getNbrEmployes(),
                });

            }
        } else {
            entete = new String[]{"identifiant", "raison sociale", "nr rue", "nom rue",
                    "code postal", "ville", "telephone", "mail", "date prospection", "interêt"};
            modelTable = new DefaultTableModel(new Object[][]{}, entete);
            modelTable.addRow(entete);

            prospects = Prospects.triRaisonSociale();


            for (Prospect prospect : prospects) {
                modelTable.addRow(new Object[]{
                        prospect.getId(),
                        prospect.getRaisonSociale(),
                        prospect.getAdresse().getRueNb(),
                        prospect.getAdresse().getRueNom(),
                        prospect.getAdresse().getCodePostal(),
                        prospect.getAdresse().getVille(),
                        prospect.getTelephone(),
                        prospect.getEmail(),
                        prospect.getDateProspection().format(DATE_FORMATTER),
                        prospect.getInteretProspect(),
                });
            }
        }
        table.setModel(modelTable);
    }
}

