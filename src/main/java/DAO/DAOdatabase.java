package DAO;

import Model.Sign;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOdatabase implements DAOInterface {
    private String url;
    private String user;
    private String password;
    private List<Sign> listOfSigns;

    public DAOdatabase(String propertiesPath) throws IOException {
        listOfSigns = new ArrayList<>();
        Properties prop = LoginData.readProperties(propertiesPath);
        url = prop.getProperty("db.url");
        user = prop.getProperty("db.user");
        password = prop.getProperty("db.password");
    }


    @Override
    public List<Sign> getSigns() {
        try(Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement("select * from signs");
            ResultSet rs = pst.executeQuery()) {

            listOfSigns.clear();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Date date = rs.getDate(3);
                Time time = rs.getTime(4);
                String message = rs.getString(5);

                Sign sign = new Sign(id, name, date, time, message);
                listOfSigns.add(sign);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DAOdatabase.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return listOfSigns;
    }

    @Override
    public Sign getSign(int searchID) {
        try(Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement("select * from signs WHERE id = ?")) {
                pst.setInt(1, searchID);
                ResultSet rs = pst.executeQuery();
                if(rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    Date date = rs.getDate(3);
                    Time time = rs.getTime(4);
                    String message = rs.getString(5);

                    return new Sign(id, name, date, time, message);
                }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DAOdatabase.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;
    }

    @Override
    public void updateSign(Sign sign, int searchID) {
        try(Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement("UPDATE signs SET name=?, date=?, time=?, message=? WHERE id = ?")) {
                pst.setString(1, sign.getName());
                pst.setDate(2, sign.getDate());
                pst.setTime(3, sign.getTime());
                pst.setString(4, sign.getMessage());
                pst.setInt(5, searchID);
                pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DAOdatabase.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    @Override
    public void deleteSign(int searchID) {
        try(Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement("DELETE FROM signs WHERE id = ?")){
                pst.setInt(1, searchID);
                pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addSign(Sign sign) {
        String AddNewSign = "INSERT INTO signs VALUES (DEFAULT, ?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(AddNewSign))
        {
            pst.setString(1, sign.getName());
            pst.setDate(2, sign.getDate());
            pst.setTime(3, sign.getTime());
            pst.setString(4, sign.getMessage());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
