package DAO;

import com.mysql.cj.xdevapi.Client;
import entities.Adresse;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoClient {
    private Connection connection;

    public DaoClient(Connection connection) {
        this.connection = connection;
    }

    // 3. Insérer un enregistrement (create)
/*    public boolean create(Client client) throws SQLException {
        String query = "INSERT INTO clients (nom, email) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, client.getNom());
            stmt.setString(2, client.getEmail());

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        }*/

        public List<Client> findAll() throws SQLException {
            List<Client> clients = new ArrayList<>();
            PreparedStatement findAllStmt = null;
            ResultSet rs = null;

            String findAllQuery = "SELECT * FROM Client";

            try {
                connection.setAutoCommit(false);
                findAllStmt = connection.prepareStatement(findAllQuery);
                rs = findAllStmt.executeQuery();

                while (rs.next()) {
                    Client client = new Client(
                            rs.getString("raisonSociale"),
                            new Adresse(rs.getString("rue"), rs.getString("ville"), rs.getString("codePostal")),
                            rs.getString("telephone"),
                            rs.getString("email"),
                            rs.getString("commentaire"),
                            rs.getLong("chiffreAffaires"),
                            rs.getInt("nbrEmployes")
                    );
                    clients.add(client);
                }

                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                if (connection != null) {
                    try {
                        System.err.println("Transaction is being rolled back");
                        connection.rollback();
                    } catch (SQLException excep) {
                        excep.printStackTrace();
                    }
                }
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (findAllStmt != null) {
                    findAllStmt.close();
                }
                connection.setAutoCommit(true);
            }

            return clients;
        }
    }
