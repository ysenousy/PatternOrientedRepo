package observer.core;

import java.util.ArrayList;
import java.util.List;

public class CustomerNotifier implements Observer {
	private List<String> notifications;

    public CustomerNotifier() {
        notifications = new ArrayList<>();
    }

    @Override
    public void update(String message) {
        notifications.add("Customer notified: " + message);
    }

    public List<String> getNotifications() {
        return notifications;
    }
}
