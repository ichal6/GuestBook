package DAO;

import Model.Sign;

import java.util.List;

public interface DAOInterface {
    List<Sign> getSigns() throws ReadError;

    Sign getSign(int id) throws ReadError;

    void updateSign(Sign sign, int id) throws ReadError;

    void deleteSign(int id) throws ReadError;

    void addSign(Sign sign) throws ReadError;
}
