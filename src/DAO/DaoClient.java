package DAO;

import gestionlog.LoggerInit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DaoClient {

    public static void findall(Connection con, String dbName) throws SQLException {
        PreparedStatement ps = null;
        String query = "select * from " + dbName + ".client";
        try {
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer idClient = rs.getInt("idClient");
                String raisonSociale = rs.getString("raisonSociale");
                String rueNb = rs.getString("rueNb");
                String rueNom = rs.getString("rueNom");
                String codePostal = rs.getString("codePostal");
                String ville = rs.getString("ville");
                String telephone = rs.getString("telephone");
                String mail = rs.getString("mail");
                String commentaires = rs.getString("commentaires");
                String chiffreAffaires = rs.getString("chiffreAffaires");
                String nbrEmployes = rs.getString("nbrEmployes");
                System.out.println(idClient + raisonSociale + rueNb + rueNom + codePostal + chiffreAffaires + nbrEmployes + commentaires + mail + ville);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("erreur de PS" + e.getMessage());
            LoggerInit.logError("Erreur de méthode findAll DAOClient",e);
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }


    public static void createClient(Connection connexion, String dbName, Integer idClient, String raisonSociale,
                                    String rueNb, String rueNom, String codePostal, String ville, String telephone,
                                    String mail, String commentaires, String chiffreAffaires,
                                    String nbrEmployes) throws SQLException {
        PreparedStatement ps = null;
        String query = "INSERT INTO " + dbName + ".client " +
                "(idClient, raisonSociale, rueNb, rueNom, codePostal, ville, telephone," +
                " mail, commentaires, chiffreAffaires, nbrEmployes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connexion.prepareStatement(query);
            ps.setInt(1, idClient);
            ps.setString(2, raisonSociale);
            ps.setString(3, rueNb);
            ps.setString(4, rueNom);
            ps.setString(5, codePostal);
            ps.setString(6, ville);
            ps.setString(7, telephone);
            ps.setString(8, mail);
            ps.setString(9, commentaires);
            ps.setString(10, chiffreAffaires);
            ps.setString(11, nbrEmployes);
            ps.executeUpdate();
            System.out.println("Nouvel enregistrement client créé avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur de PS : " + e.getMessage());
            LoggerInit.logError("Erreur de méthode createClient DAOClient",e);
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }


    public static void findClientByRaisonSociale(Connection connexion, String dbName, String raisonSociale) throws SQLException {
        PreparedStatement ps = null;
        String query = "SELECT * FROM " + dbName + ".client WHERE raisonSociale = ?";
        try {
            ps = connexion.prepareStatement(query);
            ps.setString(1, raisonSociale);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer idClient = rs.getInt("idClient");
                String rueNb = rs.getString("rueNb");
                String rueNom = rs.getString("rueNom");
                String codePostal = rs.getString("codePostal");
                String ville = rs.getString("ville");
                String telephone = rs.getString("telephone");
                String mail = rs.getString("mail");
                String commentaires = rs.getString("commentaires");
                String chiffreAffaires = rs.getString("chiffreAffaires");
                String nbrEmployes = rs.getString("nbrEmployes");
                System.out.println(mail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur de PS : " + e.getMessage());
            LoggerInit.logError("Erreur de méthode findClientByRaisonSociale DAOClient",e);
        } finally {
            if (ps != null) {
                ps.close();
            }
        }

    }

        public static void saveEmail(Connection connexion, HashMap<Integer, String> emailMap) throws SQLException {
            PreparedStatement updateEmailStmt = null;

            String updateEmailQuery = "UPDATE Client SET mail = ? WHERE idClient = ?";

            try {
                connexion.setAutoCommit(false);
                updateEmailStmt = connexion.prepareStatement(updateEmailQuery);

                for (Map.Entry<Integer, String> entry : emailMap.entrySet()) {
                    updateEmailStmt.setString(1, entry.getValue());
                    updateEmailStmt.setInt(2, entry.getKey());
                    updateEmailStmt.executeUpdate();
                    System.out.println("le mail a été modifié");

                }

                connexion.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erreur de PS : " + e.getMessage());
                LoggerInit.logError("Erreur de méthode saveEmail DAOClient",e);
                if (connexion != null) {
                    try {
                        System.err.println("Transaction is being rolled back");
                        connexion.rollback();
                    } catch (SQLException excep) {
                        excep.printStackTrace();
                        System.out.println("Erreur de connexion DAOClient" + e.getMessage());
                        LoggerInit.logError("Erreur de connexion DA0Client",e);
                    }
                }
            } finally {
                if (updateEmailStmt != null) {
                    updateEmailStmt.close();
                }
                connexion.setAutoCommit(true);
            }
        }

    public static void deleteClient(Connection connexion, List<Integer> clientIds) throws SQLException {
        PreparedStatement deleteStmt = null;
        String deleteQuery = "DELETE FROM Client WHERE idClient = ?";

        try {
            connexion.setAutoCommit(false);
            deleteStmt = connexion.prepareStatement(deleteQuery);

            for (Integer clientId : clientIds) {
                deleteStmt.setInt(1, clientId);
                deleteStmt.executeUpdate();
                System.out.println("client supprimé ok");
            }

            connexion.commit();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression : " + e.getMessage());
            LoggerInit.logError("Erreur lors de la suppression d'un client",e);
            if (connexion != null) {
                try {
                    System.out.println("Transaction is being rolled back");
                    connexion.rollback();
                } catch (SQLException excep) {
                    excep.printStackTrace();
                }
            }
        } finally {
            if (deleteStmt != null) {
                deleteStmt.close();
            }
            connexion.setAutoCommit(true);
        }
    }
}





