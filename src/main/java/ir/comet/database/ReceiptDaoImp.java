package ir.comet.database;


import ir.comet.model.Receipt;

import java.util.List;

public class ReceiptDaoImp implements ReceiptDao {

    private SqlHandler sqlHandler;

    public ReceiptDaoImp(){
        sqlHandler=new SqlHandler();
    }

    public int createReceipt(Receipt receipt) {
        sqlHandler.create(receipt);
        return 0;
    }

    public Receipt getReceipt(long receiptId) {
        return null;
    }

    public List<Receipt> getAllReceipts() {
        return null;
    }

    public void updateReceipt(Receipt receipt) {

    }

    public void deleteReceipt(Receipt receipt) {

    }
}
