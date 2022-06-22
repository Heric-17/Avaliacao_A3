package model.DAO;

public class DAOException extends Exception {

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Throwable lancavel) {
        super(lancavel);
    }

    public DAOException(String message, Throwable lancavel) {
        super(message, lancavel);
    }
}
