import DAO.DAOInterface;
import DAO.DAOdatabase;
import Model.Sign;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            LocalDate localDate = LocalDate.now();
            Date date = Date.valueOf(localDate);
            DAOInterface dao = new DAOdatabase("src/main/resources/database.properties");
            Sign newSign= new Sign(1,"Michał Lechowicz",date,"Przykładowy tekst");
            dao.addSign(newSign);
            System.out.println(dao.getSigns().get(0).getId());
            System.out.println(dao.getSigns().get(0).getName());
            System.out.println(dao.getSigns().get(0).getDate());
            System.out.println(dao.getSigns().get(0).getMessage());



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
