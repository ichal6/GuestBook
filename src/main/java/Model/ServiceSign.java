package Model;

import DAO.DAOInterface;
import DAO.DAOdatabase;
import DAO.ReadError;

import java.io.IOException;
import java.util.List;

public class ServiceSign {
    public static List<Sign> getAllSigns() throws IOException, ReadError {
        DAOInterface dao = new DAOdatabase("src/main/resources/database.properties");
        return dao.getSigns();
    }
}
