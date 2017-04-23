package ir.comet.database;

import ir.comet.model.Branch;
import ir.comet.model.Comment;
import ir.comet.model.WareHouse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public class WareHouseDaoImp implements WareHouseDao {

    private SqlHandler sqlHandler;

    public WareHouseDaoImp(){
        sqlHandler=SqlHandler.getInstance();
    }

    public void createWareHouse(WareHouse wareHouse) {
        sqlHandler.create(wareHouse);
    }

    public WareHouse getWareHouse(long wareHouseId) {
        return (WareHouse) sqlHandler.getObjectsBySpecialColumn(this.getClass(),"wareHouseId",wareHouseId).get(0);
    }

    public void updateWareHouse(WareHouse wareHouse) {
        sqlHandler.update(wareHouse);
    }

    public void deleteWareHouse(WareHouse wareHouse) {
        sqlHandler.delete(wareHouse);
    }
}
