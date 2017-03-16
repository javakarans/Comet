package ir.comet.database;


import ir.comet.model.Notification;

import java.util.List;

public interface NotificationDao {
    public void createNotification(Notification notification);
    public Notification getNotification(long notificationId);
    public List<Notification> getAllNotifications();
    public void updateNotification(Notification notification);
    public void deleteNotification(Notification notification);
}
