package p02_services;

public class Main {
    public static void main(String[] args) {
        NotificationService compositeNotificationService = new CompositeNotificationService(
                true,
                new EmailNotificationService(true),
                new SmsNotificationService(true));

        OnlineStoreOrder onlineStoreOrder = new OnlineStoreOrder(compositeNotificationService);
        onlineStoreOrder.process();
    }
}
