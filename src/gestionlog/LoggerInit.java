package gestionlog;


import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

/** classe qui gère la création des logs, où ils doivent être enregistrés
 * */
public class LoggerInit {
    public static final Logger LOGGER = Logger.getLogger(LoggerInit.class.getName());
    private static FileHandler fh = null;

    public void initFileLogger() throws IOException {
        fh = new FileHandler("logs/LogEcfGestionClients.log", true);
        LOGGER.setUseParentHandlers(false);
        LOGGER.addHandler(fh);
        fh.setFormatter(new FormatterLog());}

        public static void logError(String message, Exception e) {
            LOGGER.severe(message + " | Exception: " + e.getMessage());
    }
}
