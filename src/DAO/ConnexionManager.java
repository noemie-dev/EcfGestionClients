package DAO;

import gestionlog.LoggerInit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnexionManager {
    private static Connection connexion = null;

    public static Connection getConnection() {
        if (connexion == null) {
            try {
                final Properties dataProperties = new Properties();
                File fichier = new File("database.properties");
                FileInputStream input = new FileInputStream(fichier);
                dataProperties.load(input);
                System.out.println("fichier ok");

                connexion = DriverManager.getConnection(
                        dataProperties.getProperty("url"),
                        dataProperties.getProperty("login"),
                        dataProperties.getProperty("password")
                );
            } catch (IOException | SQLException e ) {
                e.printStackTrace();
                System.out.println("Erreur de connexion" + e.getMessage());
                LoggerInit.logError("Erreur de connexion avec la base de donnees",e);
//                throw new Exception("Erreur de connexion");
            }
        }
        System.out.println(connexion);
            return connexion;
        }
    }
