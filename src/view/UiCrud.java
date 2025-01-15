package view;


import entities.*;
import utilities.ChoixClientProspect;
import utilities.ChoixCrud;
import utilities.OuiNon;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.logging.Level;

import static gestionlog.LoggerInit.LOGGER;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

/** Classe représentant l'interface utilisateur pour les opérations CRUD (Créer, Lire, Modifier, Supprimer)
 * sur les entités Client et Prospect.
 */
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

    /** Constructeur modifier ou supprimer un client
     *
     * @param choixCrud
     * @param clientChoisi
     */
    public UiCrud(ChoixCrud choixCrud, Client clientChoisi) {
        initComponents();
        setTitle("Modifier un client");
        this.choixCrud = choixCrud;
        this.client = clientChoisi;
        choixClasse = ChoixClientProspect.CLIENT;
        labelsClientProspect(); // Configure l'interface en fonction du type d'entité (Client/Prospect)
        initRemplissageTextField(); // Préremplit les champs avec les données du client ou du prospect
        crudValiderButton.setText(choixCrud.toString()); // Configure le bouton en fonction de l'opération
        if (choixCrud == ChoixCrud.SUPPRIMER) {
            nonEditableTextfield(); // Rend les champs non modifiables
            setTitle("Supprimer un client");
        }
        listeners();

    }

    /** constructeur pour modifier ou supprimer un prospect
     *
     * @param choixCrud
     * @param prospectChoisi
     */
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

    /** constructeur pour creer
     *
     * @param choixClientProspect
     */
    public UiCrud(ChoixClientProspect choixClientProspect) {
        initComponents();
        setTitle("Créer un client");
        this.choixClasse = choixClientProspect;
        this.choixCrud = ChoixCrud.CREER;
        labelsClientProspect();
        idTextField.setText(String.valueOf(Client.getCompteurIdClient())); //
        // je recupère l'identifiant dans ma classe Client avec un getter static
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
                // en fonction du choix crud, quand on clique sur le bouton de validation, on appelle telle méthode :
                try {
                    switch (choixCrud) {
                        case CREER:

                            validerCreation();

                            break;

                        case MODIFIER:
                            validerModification();
                            break;


                        case SUPPRIMER:
                            validerSuppression();
                            break;

                    }
                    dispose();
                    UiAccueil2 uiAccueil2 = new UiAccueil2();
                    uiAccueil2.setVisible(true);


                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erreur : format de numéro invalide");
                } catch (DateTimeException ex) {
                    JOptionPane.showMessageDialog(null, "Erreur : format de date invalide");
                } catch (Exception ex) {
                    LOGGER.log(Level.SEVERE, "Crash de l'application", ex);
                    JOptionPane.showMessageDialog(null, "Erreur : fermeture de l'application");
                    System.exit(1);

                }
            }
        });
    }

    /** methode pour invoquer les composants de l'interface dans le constructeur
     *
     */
    private void initComponents() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(retourButton);
        setSize(900, 900);
    }

    /** Configure les labels et champs visibles en fonction du type d'entité (Client ou Prospect).
     *
     */
    private void labelsClientProspect() {
        idTextField.setEditable(false);
        if (client != null || choixClasse == ChoixClientProspect.CLIENT) {
            // si client n'est pas null ou que ce que je vient de créer est bien un client :
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

    /** remplit les textFields en fonction de l'entité choisie
     *
     */
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

    /**rend les textfields non editables
     *
     */
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

    }

    /** methode pour le bouton valider en fonction du choix d'entité quand une création est finie
     *
     * @throws SaisieException
     * @throws NullPointerException
     */
    private void validerCreation() { // constructeur avec le contenu des textfields
        try {
            if (choixClasse == ChoixClientProspect.CLIENT) {
                Clients.getClients().add(new Client(
                        raisonSocTextField.getText(),
                        new Adresse(nbRueTextField.getText(), nomRueTextField.getText(),
                                codePostalTextField.getText(), villeTextField.getText()),
                        telephoneTextField.getText(),
                        emailTextField.getText(),
                        commTextArea.getText(),
                        parseLong(chiffreAffairetextField.getText()),
                        parseInt(nbEmployesTextField.getText())
                ));
            } else {
                Prospects.getProspects().add(new Prospect(
                        raisonSocTextField.getText(),
                        new Adresse(nbRueTextField.getText(), nomRueTextField.getText(),
                                codePostalTextField.getText(), villeTextField.getText()),
                        telephoneTextField.getText(),
                        emailTextField.getText(),
                        commTextArea.getText(),
                        LocalDate.parse(dateProspectTextField.getText()),
                        OuiNon.valueOf(ouiNonCombobox.getSelectedItem().toString())
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

    /** methode pour le bouton valider en fonction du choix d'entité quand une modification est finie
     *
      * @throws SaisieException
     * @throws NullPointerException
     */
    private void validerModification() {
        try {
            if (choixClasse == ChoixClientProspect.CLIENT) {
                client.setRaisonSociale(raisonSocTextField.getText());
                client.setAdresse(new Adresse(nbRueTextField.getText(), nomRueTextField.getText(),
                        codePostalTextField.getText(), villeTextField.getText()));
                client.setTelephone(telephoneTextField.getText());
                client.setEmail(emailTextField.getText());
                client.setCommentaire(commTextArea.getText());
                client.setChiffreAffaires(parseLong(chiffreAffairetextField.getText()));
                client.setNbrEmployes(parseInt(nbEmployesTextField.getText()));
            } else if (choixClasse == ChoixClientProspect.PROSPECT) {
                prospect.setRaisonSociale(raisonSocTextField.getText());
                prospect.setAdresse(new Adresse(nbRueTextField.getText(), nomRueTextField.getText(),
                        codePostalTextField.getText(), villeTextField.getText()));
                prospect.setTelephone(telephoneTextField.getText());
                prospect.setEmail(emailTextField.getText());
                prospect.setCommentaire(commTextArea.getText());
                prospect.setDateProspection(LocalDate.parse(dateProspectTextField.getText()));
                prospect.setInteretProspect(OuiNon.valueOf(ouiNonCombobox.getSelectedItem().toString()));

            }
            JOptionPane.showMessageDialog(null,"la modification est prise en compte");


        } catch (SaisieException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        catch (DateTimeException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /** methode pour le bouton valider en fonction du choix d'entité quand une suppression est finie
     *
     * @throws SaisieException
     */
    private void validerSuppression() {
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
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()+"Ne peut pas être nul");
        }
    }

}

