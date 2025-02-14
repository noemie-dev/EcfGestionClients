package DAO;

public class ProjetDaoException extends Exception {

    private int gravity;

    public ProjetDaoException(String message, int gravity) {
        super(message);
        this.gravity = gravity;
    }
    public int getGravity() {
        return gravity;
    }
}
