package ir.comet.database;

import ir.comet.model.Branch;
import ir.comet.model.Receipt;

import java.util.List;

public interface ReceiptDao {
    public boolean createReceipt(Receipt receipt);
    public Receipt getReceipt(long receiptId);
    public List<Receipt> getAllReceipts();
    public boolean updateReceipt(Receipt receipt);
    public boolean deleteReceipt(Receipt receipt);
}
