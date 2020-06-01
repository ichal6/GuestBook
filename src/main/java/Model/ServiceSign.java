package Model;

import DAO.DAOInterface;
import DAO.DAOdatabase;

import java.io.IOException;
import java.util.List;

public class ServiceSign {
    public static List<Sign> getAllSigns() throws IOException {
        DAOInterface dao = new DAOdatabase("/home/michael/Dropbox/Codecool/Weekendowy/3.WEB/2nd_Sprint/1.Pre-Work/GuestBook/src/main/resources/database.properties");
        return dao.getSigns();
    }
}
