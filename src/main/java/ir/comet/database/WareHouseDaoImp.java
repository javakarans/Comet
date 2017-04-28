package ir.comet.database;

import ir.comet.model.WareHouse;

/**
 * Created by Mohammad on 2/28/2017.
 */
public class WareHouseDaoImp implements WareHouseDao {

    private SQLService SQLService;

    public WareHouseDaoImp(){
        SQLService = new SQLService();
    }

    public void createWareHouse(WareHouse wareHouse) {
        SQLService.create(wareHouse);
    }

    public WareHouse getWareHouse(long wareHouseId) {
        return (WareHouse) SQLService.getObjectsBySpecialColumn(this.getClass(),"wareHouseId",wareHouseId).get(0);
    }

    public void updateWareHouse(WareHouse wareHouse) {
        SQLService.update(wareHouse);
    }

    public void deleteWareHouse(WareHouse wareHouse) {
        SQLService.delete(wareHouse);
    }
}
