package DAO;

import com.mysql.cj.xdevapi.Client;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoClient {
    private Connection connection;

    public DaoClient(Connection connection) {
        this.connection = connection;
    }

    // 3. Insérer un enregistrement (create)
    public boolean create(Client client) throws SQLException {
        String query = "INSERT INTO clients (nom, email) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, client.getNom());
            stmt.setString(2, client.getEmail());

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        }
    }

}
