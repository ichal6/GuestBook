package DAO;

public class ReadError extends Exception {
    public ReadError(String errorMessage) {
        super(errorMessage);
    }
}
