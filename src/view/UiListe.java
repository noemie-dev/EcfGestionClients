package view;

import entities.Client;
import entities.Prospect;
import utilities.ChoixClientProspect;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static entities.Clients.clients;
import static entities.Prospects.prospects;
import static utilities.Regex.DATE_FORMATTER;

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

    private void remplissageJTable(ChoixClientProspect choixClientProspect) {
        DefaultTableModel modelTable ;
        String[] entete;
        if (choixClientProspect == ChoixClientProspect.CLIENT) {
            entete = new String[]{"identifiant", "raison sociale", "nr rue", "nom rue", "code postal", "ville", "telephone", "mail", "CA", "nbr employés"};
            modelTable = new DefaultTableModel(new Object[][]{}, entete);
            modelTable.addRow(entete);

//            choixTriRaisonSoc = Clients.triRaisonSociale();

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
            entete = new String[]{"identifiant", "raison sociale", "nr rue", "nom rue", "code postal", "ville", "telephone", "mail", "date prospection", "interêt"};
            modelTable = new DefaultTableModel(new Object[][]{}, entete);
            modelTable.addRow(entete);

            // choixTriRaisonSoc = Prospects.triRaisonSociale();


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

