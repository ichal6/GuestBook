package DAO;

import Model.Sign;

import java.util.List;

public interface DAOInterface {
    public List<Sign> getSigns();

    public Sign getSign(int id);

    public void updateSign(Sign sign, int id);

    public void deleteSign(int id);

    public void addSign(Sign sign);
}
