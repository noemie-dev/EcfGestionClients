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
    private JTextField interetProspectTextField;
    private JLabel interetProspectLabel;
    private JLabel dateProspectLabel;
    private JComboBox ouiNonCombobox;
    private ChoixCrud choixCrud;
    private Client client;
    private Prospect prospect;
    private ChoixClientProspect choixClientProspect;

    // Constructeur modifier ou supprimer un client
    public UiCrud(ChoixCrud choixCrud, Client clientChoisi) {
        initComponents();
        setTitle("Modifier un client");
        this.choixCrud = choixCrud;
        this.client = clientChoisi;
        labelsClientProspect();
        initRemplissageTextField();
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
        labelsClientProspect();
        initRemplissageTextField();
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
        this.choixClientProspect = choixClientProspect;
        this.choixCrud = ChoixCrud.CREER;
        labelsClientProspect();
        idTextField.setText(String.valueOf(Client.getCompteurIdClient())); // je recupère l'identifiant dans ma classe avec un getter static
        listeners();

    }

    private void listeners() {
        crudValiderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // en fonction du choix crud :
                switch (choixCrud) {
                    case CREER:
                        try {
                            validerCreation();
                        } catch (SaisieException ex) {
                            throw new RuntimeException(ex);
                        }
                        ;
                    case MODIFIER:
                        try {
                            validerModification();
                        } catch (SaisieException ex) {
                            throw new RuntimeException(ex);
                        }

                        ;
                    case SUPPRIMER:
                        try {
                            validerSuppression();
                        } catch (SaisieException ex) {
                            throw new RuntimeException(ex);
                        }
                        ;

                }

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
        if (client != null || choixClientProspect == ChoixClientProspect.CLIENT) { // si client n'est pas null ou que ce que je vient de créer est bien un client :
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
            // continuer à set les trucs dans les textfields
        } else {
            idTextField.setText(String.valueOf(prospect.getId()));
            raisonSocTextField.setText(prospect.getRaisonSociale());
            //same
        }
    }

    private void nonEditableTextfield() {
        idTextField.setEditable(false);
        raisonSocTextField.setEditable(false);
        // same
    }

    private void validerCreation() throws SaisieException { // constructeur avec le contenu des textfields
        try {
            if (choixClientProspect == ChoixClientProspect.CLIENT) {
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

            JOptionPane.showMessageDialog(null, "BIEN JOUER NONOOOOO");

        } catch (SaisieException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void validerModification() throws SaisieException {
        try {
            if (choixClientProspect == ChoixClientProspect.CLIENT) {
                client.setRaisonSociale(raisonSocTextField.getText());
                client.setAdresse(new Adresse(nbRueTextField.getText(), nomRueTextField.getText(), codePostalTextField.getText(), villeTextField.getText()));
                client.setTelephone(telephoneTextField.getText());
                client.setEmail(emailTextField.getText());
                client.setCommentaire(commTextArea.getText());
                client.setChiffreAffaires(parseLong(chiffreAffairetextField.getText()));
                client.setNbrEmployes(parseInt(nbEmployesTextField.getText()));
            } else {
                prospect.setRaisonSociale(raisonSocTextField.getText());
                prospect.setAdresse(new Adresse(nbRueTextField.getText(), nomRueTextField.getText(), codePostalTextField.getText(), villeTextField.getText()));
                prospect.setTelephone(telephoneTextField.getText());
                prospect.setEmail(emailTextField.getText());
                prospect.setCommentaire(commTextArea.getText());
                prospect.setDateProspection(dateProspectTextField.getText());
                prospect.setInteretProspect(ouiNonCombobox.getSelectedItem().toString());

            }

        } catch (SaisieException e) {
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
                if (choixClientProspect == ChoixClientProspect.CLIENT) {
                    Clients.getClients().remove(client);
                    JOptionPane.showMessageDialog(this, "client supprimé avec succes");
                } else {
                    Prospects.getProspects().remove(prospect);
                    JOptionPane.showMessageDialog(this, "prospect suprrimé");
                }
            } else {
                JOptionPane.showMessageDialog(this, "suppression annulee");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

