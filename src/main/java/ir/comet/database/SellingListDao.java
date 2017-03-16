package ir.comet.database;

import ir.comet.model.SellingList;

import java.util.List;

public interface SellingListDao {
    public void createSellingList(SellingList sellingList);
    public SellingList getSellingList(long sellingListId);
    public List<SellingList> getAllSellingLists();
    public void updateSellingList(SellingList sellingList);
    public void deleteSellingList(SellingList sellingList);
}
