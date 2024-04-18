package core.observer.pattern;

import java.io.File;

public class Demo {
	public static void main(String[] args) {
        Editor editor = new Editor();
        
        EventListener openListener = new EventListener() {
            @Override
            public void update(String eventType, File file) {
                System.out.println("File opened: " + file.getPath());
            }
        };

        EventListener saveListener = new EventListener() {
            @Override
            public void update(String eventType, File file) {
                System.out.println("File saved: " + file.getPath());
            }
        };

        editor.getEvents().subscribe("open", openListener);
        editor.getEvents().subscribe("save", saveListener);

        try {
            editor.openFile("test.txt");
            editor.saveFile();

            // Unsubscribe openListener
            editor.getEvents().unsubscribe("open", openListener);

            // Trying to open another file. The openListener won't be notified this time.
            editor.openFile("anotherTest.txt");

            // Save event should still notify saveListener.
            editor.saveFile();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
