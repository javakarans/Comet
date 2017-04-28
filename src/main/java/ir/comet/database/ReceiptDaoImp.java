package ir.comet.database;


import ir.comet.model.Receipt;

import java.util.List;

public class ReceiptDaoImp implements ReceiptDao {

    private SQLService SQLService;

    public ReceiptDaoImp(){
        SQLService =new SQLService();
    }

    public int createReceipt(Receipt receipt) {
        SQLService.create(receipt);
        return 1;
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
