package ir.comet.database;

import ir.comet.model.Branch;
import ir.comet.model.Receipt;

import java.util.List;

public interface ReceiptDao {
    public int createReceipt(Receipt receipt);
    public Receipt getReceipt(long receiptId);
    public List<Receipt> getAllReceipts();
    public void updateReceipt(Receipt receipt);
    public void deleteReceipt(Receipt receipt);
}
