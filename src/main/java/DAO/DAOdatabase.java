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
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement("select * from signs");
             ResultSet rs = pst.executeQuery()) {
            listOfSigns.clear();
            int attributesNumber = rs.getMetaData().getColumnCount();
            String[] adminAttributes = new String[attributesNumber];

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Date date = rs.getDate(3);
                String message = rs.getString(4);

                Sign sign = new Sign(id, name, date, message);
                listOfSigns.add(sign);
                con.close();
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DAOdatabase.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return listOfSigns;
    }

    @Override
    public Sign getSign(int id) {
        return null;
    }

    @Override
    public void updateSign(Sign sign, int id) {

    }

    @Override
    public void deleteSign(int id) {

    }

    @Override
    public void addSign(Sign sign) {
        String AddToUser_tableStatement = "INSERT INTO signs VALUES (DEFAULT, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(AddToUser_tableStatement))
        {
            pst.setString(1, sign.getName());
            pst.setDate(2, sign.getDate());
            pst.setString(3, sign.getMessage());
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
