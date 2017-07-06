package ir.comet.database;

import ir.comet.model.OrderDetail;
import ir.comet.model.ProductOrderDetail;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Mohammad on 4/28/2017.
 */
public class PaymentTransaction {


    private List<ProductOrderDetail> productOrderDetailList;
    private OrderDetail orderDetail;

    public PaymentTransaction(List<ProductOrderDetail> productOrderDetailList,OrderDetail orderDetail){
        this.productOrderDetailList=productOrderDetailList;
        this.orderDetail=orderDetail;
    }

    public boolean confirmPayment(){
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            session.save(orderDetail);
            Iterator<ProductOrderDetail> iterator = productOrderDetailList.iterator();
            while (iterator.hasNext()){
                ProductOrderDetail next = iterator.next();
                long soldCount = next.getProduct().getSoldCount()+1;
                next.getProduct().setSoldCount(soldCount);
                long stock = next.getProduct().getStock()-1;
                next.getProduct().setStock(stock);
                next.setOrderDetail(orderDetail);
                session.update(next.getProduct());
                session.save(next);
            }
            HibernateUtil.commitTransaction();
            return true;
        }catch (HibernateException e){
            HibernateUtil.rollbackTransaction();
        }
        return false;
    }

    public List<ProductOrderDetail> getProductOrderDetailList() {
        return productOrderDetailList;
    }

    public void setProductOrderDetailList(List<ProductOrderDetail> productOrderDetailList) {
        this.productOrderDetailList = productOrderDetailList;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }
}
