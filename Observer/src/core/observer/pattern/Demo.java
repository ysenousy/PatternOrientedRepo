package core.observer.pattern;

public class Demo {
    public static void main(String[] args) {
        
    	Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));
        
        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       
        editor.events.unsubscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.unsubscribe("save", new EmailNotificationListener("admin@example.com"));
        
        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
