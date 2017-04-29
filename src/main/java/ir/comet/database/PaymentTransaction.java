package ir.comet.database;

import ir.comet.model.OrderDetail;
import ir.comet.model.PaymentDetail;
import ir.comet.model.Receipt;
import ir.comet.wrapper.UserProductCart;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Mohammad on 4/28/2017.
 */
public class PaymentTransaction {

    private long customerId;
    private OrderDetail orderDetail;
    private Receipt receipt;
    private List<UserProductCart> userProductCartList;

    public PaymentTransaction(PaymentDetail paymentDetail){
        customerId = paymentDetail.getCustomerId();
        orderDetail = paymentDetail.getOrderDetail();
        receipt = paymentDetail.getReceipt();
        userProductCartList = paymentDetail.getUserProductCartList();
    }
    public boolean confirmPayment(){
        try{
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            session.save(receipt);
            Criteria criteria = session.createCriteria(Receipt.class);
            List<Receipt> receiptList=criteria.list();
            long receiptId = receiptList.get(receiptList.size() - 1).getReceiptId();
            orderDetail.setReceiptId(receiptId);
            orderDetail.setStatus("");
            orderDetail.setCustomerId(customerId);
            session.save(orderDetail);
            Criteria criteria1 = session.createCriteria(OrderDetail.class);
            List<OrderDetail> orderDetailList =criteria1.list();
            long orderId = orderDetailList.get(orderDetailList.size() - 1).getOrderId();
            Iterator<UserProductCart> iterator = userProductCartList.iterator();
            while (iterator.hasNext()){
                UserProductCart next = iterator.next();
                next.getProductCart().setOrderId(orderId);
                session.save(next.getProductCart());
            }
            HibernateUtil.commitTransaction();
            return true;
        }catch (HibernateException e){
            HibernateUtil.rollbackTransaction();
        }
        return false;
    }
}
