package DAO;
import entities.Adresse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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
                System.out.println(idClient+raisonSociale+rueNb+rueNom+codePostal+chiffreAffaires+nbrEmployes+commentaires+mail+ville);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("erreur de PS" + e.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }
}

