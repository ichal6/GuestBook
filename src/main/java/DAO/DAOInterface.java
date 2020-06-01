package DAO;

import Model.Sign;

import java.util.List;

public interface DAOInterface {
    List<Sign> getSigns();

    Sign getSign(int id);

    void updateSign(Sign sign, int id);

    void deleteSign(int id);

    void addSign(Sign sign);
}
