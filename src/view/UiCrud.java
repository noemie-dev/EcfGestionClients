package view;

import entities.*;
import utilities.ChoixClientProspect;
import utilities.ChoixCrud;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

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
    private JTextArea commTextArea;
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
    private JLabel chiffreAffairesLabel;
    private JLabel nbEmployesLabel;
    private JTextField dateProspectTextField;
    private JLabel interetProspectLabel;
    private JLabel dateProspectLabel;
    private JComboBox ouiNonCombobox;
    private ChoixCrud choixCrud;
    private Client client;
    private Prospect prospect;
    private ChoixClientProspect choixClasse;

    // Constructeur modifier ou supprimer un client
    public UiCrud(ChoixCrud choixCrud, Client clientChoisi) {
        initComponents();
        setTitle("Modifier un client");
        this.choixCrud = choixCrud;
        this.client = clientChoisi;
        choixClasse = ChoixClientProspect.CLIENT;
        labelsClientProspect();
        initRemplissageTextField();
        crudValiderButton.setText(choixCrud.toString());
        if (choixCrud == ChoixCrud.SUPPRIMER) {
            nonEditableTextfield();
            setTitle("Supprimer un client");
        }
        listeners();

    }

    // constructeur pour modifier ou supprimer un prospect
    public UiCrud(ChoixCrud choixCrud, Prospect prospectChoisi) {
        initComponents();
        setTitle("Modifier un prospect");
        this.choixCrud = choixCrud;
        this.prospect = prospectChoisi;
        choixClasse = ChoixClientProspect.PROSPECT;
        labelsClientProspect();
        initRemplissageTextField();
        crudValiderButton.setText(choixCrud.toString());
        if (choixCrud == ChoixCrud.SUPPRIMER) {
            nonEditableTextfield();
            setTitle("Supprimer un prospect");
        }
        listeners();
    }

    // constructeur pour creer
    public UiCrud(ChoixClientProspect choixClientProspect) {
        initComponents();
        setTitle("Créer un client");
        this.choixClasse = choixClientProspect;
        this.choixCrud = ChoixCrud.CREER;
        labelsClientProspect();
        idTextField.setText(String.valueOf(Client.getCompteurIdClient())); // je recupère l'identifiant dans ma classe avec un getter static
        crudValiderButton.setText(choixCrud.toString());
        listeners();

    }

    private void listeners() {

        retourButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Voulez allez être redirigé vers l'accueil");
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


        crudValiderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // en fonction du choix crud :
                switch (choixCrud) {
                    case CREER:
                        try {
                            validerCreation();
                        } catch (SaisieException ex) {
                            JOptionPane.showMessageDialog(null, "Erreur : creation annulée");
                        }
                        break;

                    case MODIFIER:
                        try {
                            validerModification();
                            JOptionPane.showMessageDialog(null,"c'est validé");
                        } catch (SaisieException ex) {
                            JOptionPane.showMessageDialog(null, "Erreur : modification annulée");
                        }
                        break;


                    case SUPPRIMER:
                        try {
                            validerSuppression();
                        } catch (SaisieException ex) {
                            JOptionPane.showMessageDialog(null, "Erreur : suppression annulée");;
                        }
                        break;

                }
                dispose();
                UiAccueil2 uiAccueil2 = new UiAccueil2();
                uiAccueil2.setVisible(true);

            }
        });
    }


    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


    /*    retourButton.addActionListener(new ActionListener() {
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
    }*/

    private void initComponents() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(retourButton);
        setSize(900, 900);
    }

    private void labelsClientProspect() {
        idTextField.setEditable(false);
        if (client != null || choixClasse == ChoixClientProspect.CLIENT) { // si client n'est pas null ou que ce que je vient de créer est bien un client :
            chiffreAffairesLabel.setVisible(true);
            chiffreAffairetextField.setVisible(true);
            nbEmployesLabel.setVisible(true);
            nbEmployesTextField.setVisible(true);
            dateProspectLabel.setVisible(false);
            dateProspectTextField.setVisible(false);
            interetProspectLabel.setVisible(false);

            ouiNonCombobox.setVisible(false);
        } else {
            dateProspectLabel.setVisible(true);
            dateProspectTextField.setVisible(true);
            interetProspectLabel.setVisible(true);
            ouiNonCombobox.setVisible(true);
            chiffreAffairesLabel.setVisible(false);
            chiffreAffairetextField.setVisible(false);
            nbEmployesLabel.setVisible(false);
            nbEmployesTextField.setVisible(false);
        }

    }

    private void initRemplissageTextField() {
        if (client != null) {
            idTextField.setText(String.valueOf(client.getId()));
            raisonSocTextField.setText(client.getRaisonSociale());
            nbRueTextField.setText(client.getAdresse().getRueNb());
            nomRueTextField.setText(client.getAdresse().getRueNom());
            codePostalTextField.setText(client.getAdresse().getCodePostal());
            villeTextField.setText(client.getAdresse().getVille());
            telephoneTextField.setText(client.getTelephone());
            emailTextField.setText(client.getEmail());
            commTextArea.setText(client.getCommentaire());
            chiffreAffairetextField.setText(String.valueOf(client.getChiffreAffaires()));
            nbEmployesTextField.setText(String.valueOf(client.getNbrEmployes()));
            // continuer à set les trucs dans les textfields
        } else {
            idTextField.setText(String.valueOf(prospect.getId()));
            raisonSocTextField.setText(prospect.getRaisonSociale());
            nbRueTextField.setText(prospect.getAdresse().getRueNb());
            nomRueTextField.setText(prospect.getAdresse().getRueNom());
            codePostalTextField.setText(prospect.getAdresse().getCodePostal());
            villeTextField.setText(prospect.getAdresse().getVille());
            telephoneTextField.setText(prospect.getTelephone());
            emailTextField.setText(prospect.getEmail());
            commTextArea.setText(prospect.getCommentaire());
            dateProspectTextField.setText(prospect.getDateProspection().toString());
            ouiNonCombobox.getSelectedItem();

            //same
        }
    }

    private void nonEditableTextfield() {
        idTextField.setEditable(false);
        raisonSocTextField.setEditable(false);
        nbRueTextField.setEditable(false);
        nomRueTextField.setEditable(false);
        codePostalTextField.setEditable(false);
        villeTextField.setEditable(false);
        telephoneTextField.setEditable(false);
        emailTextField.setEditable(false);
        commTextArea.setEditable(false);
        chiffreAffairetextField.setEditable(false);
        nbEmployesTextField.setEditable(false);
        dateProspectTextField.setEditable(false);
        ouiNonCombobox.setEditable(false);

        // same
    }

    private void validerCreation() throws SaisieException, NullPointerException { // constructeur avec le contenu des textfields
        try {
            if (choixClasse == ChoixClientProspect.CLIENT) {
                Clients.getClients().add(new Client(
                        raisonSocTextField.getText(),
                        new Adresse(nbRueTextField.getText(), nomRueTextField.getText(), codePostalTextField.getText(), villeTextField.getText()),
                        telephoneTextField.getText(),
                        emailTextField.getText(),
                        commTextArea.getText(),
                        parseLong(chiffreAffairetextField.getText()),
                        parseInt(nbEmployesTextField.getText())
                ));
            } else {
                Prospects.getProspects().add(new Prospect(
                        raisonSocTextField.getText(),
                        new Adresse(nbRueTextField.getText(), nomRueTextField.getText(), codePostalTextField.getText(), villeTextField.getText()),
                        telephoneTextField.getText(),
                        emailTextField.getText(),
                        commTextArea.getText(),
                        dateProspectTextField.getText(),
                        ouiNonCombobox.getSelectedItem().toString()
                ));
            }

            JOptionPane.showMessageDialog(null, "la creation est bien prise en compte");


        } catch (SaisieException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void validerModification() throws SaisieException, NullPointerException {
        try {
            if (choixClasse == ChoixClientProspect.CLIENT) {
                client.setRaisonSociale(raisonSocTextField.getText());
                client.setAdresse(new Adresse(nbRueTextField.getText(), nomRueTextField.getText(), codePostalTextField.getText(), villeTextField.getText()));
                client.setTelephone(telephoneTextField.getText());
                client.setEmail(emailTextField.getText());
                client.setCommentaire(commTextArea.getText());
                client.setChiffreAffaires(parseLong(chiffreAffairetextField.getText()));
                client.setNbrEmployes(parseInt(nbEmployesTextField.getText()));
            } else if (choixClasse == ChoixClientProspect.PROSPECT) {
                prospect.setRaisonSociale(raisonSocTextField.getText());
                prospect.setAdresse(new Adresse(nbRueTextField.getText(), nomRueTextField.getText(), codePostalTextField.getText(), villeTextField.getText()));
                prospect.setTelephone(telephoneTextField.getText());
                prospect.setEmail(emailTextField.getText());
                prospect.setCommentaire(commTextArea.getText());
                prospect.setDateProspection(dateProspectTextField.getText());
                prospect.setInteretProspect(ouiNonCombobox.getSelectedItem().toString());

            }
            JOptionPane.showMessageDialog(null,"la modification est prise en compte");


        } catch (SaisieException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void validerSuppression() throws SaisieException {
        try {
            int confirmation = JOptionPane.showConfirmDialog(this,
                    "etes vous sûrs de vouloir supprimer cette fiche ? ",
                    "confirmation de suppression",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (confirmation == JOptionPane.YES_OPTION) {
                if (choixClasse == ChoixClientProspect.CLIENT) {
                    Clients.getClients().remove(client);
                    JOptionPane.showMessageDialog(this, "client supprimé avec succès");
                } else if (choixClasse == ChoixClientProspect.PROSPECT) {
                    Prospects.getProspects().remove(prospect);
                    JOptionPane.showMessageDialog(this, "prospect supprimé");

                }
            } else {
                JOptionPane.showMessageDialog(this, "suppression annulée");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

