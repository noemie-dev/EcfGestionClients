package entities;

/** classe d'exception personnalisée pour relever les problèmes liés à la saisie de l'utilisateur, heritant de la classe Exception
 * */
public class SaisieException extends Exception {
    public SaisieException(String message) {
        super(message);
    }
}
