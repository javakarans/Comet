package ir.comet.database;


import ir.comet.model.WareHouse;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public interface WareHouseDao {

    public void createWareHouse(WareHouse wareHouse);
    public WareHouse getWareHouse(long wareHouseId);
    public void updateWareHouse(WareHouse wareHouse);
    public void deleteWareHouse(WareHouse wareHouse);

}
