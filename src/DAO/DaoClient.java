package DAO;
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
                String raisonSociale = rs.getString("raisonSociale");
                System.out.println(raisonSociale);
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

