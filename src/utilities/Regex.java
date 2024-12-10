package utilities;

import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Regex {
    public static final Pattern PATTERN_CODE_POSTAL = Pattern.compile("^[0-9]{5}$");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final Pattern PATTERN_TELEPHONE = Pattern.compile("^\\+?\\d{1,4}\\d{1,14}$");
    /* La norme E. 164 autorise une longueur maximale de 15 chiffres pour le numéro de téléphone international complet composé
     de l'indicatif du pays, du code d'acheminement national (indicatif régional) et du numéro d'abonné.
     */
    public static final Pattern PATTERN_EMAIL = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
}
