package ir.comet.database;


import ir.comet.model.Receipt;

import java.util.List;

public class ReceiptDaoImp implements ReceiptDao {

    private SQLService sqlService;

    public ReceiptDaoImp(){
        sqlService =new SQLService();
    }

    public boolean createReceipt(Receipt receipt) {
        return sqlService.create(receipt);
    }

    public Receipt getReceipt(long receiptId) {
        return null;
    }

    public List<Receipt> getAllReceipts() {
        return null;
    }

    public boolean updateReceipt(Receipt receipt) {
        return sqlService.update(receipt);
    }

    public boolean deleteReceipt(Receipt receipt) {
        return sqlService.delete(receipt);
    }
}
