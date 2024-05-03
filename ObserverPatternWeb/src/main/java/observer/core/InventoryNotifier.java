package observer.core;

import java.util.ArrayList;
import java.util.List;

public class InventoryNotifier implements Observer {
	private List<String> notifications;

    public InventoryNotifier() {
        notifications = new ArrayList<>();
    }

    @Override
    public void update(String message) {
        notifications.add("Inventory updated: " + message);
    }

    public List<String> getNotifications() {
        return notifications;
    }
}
