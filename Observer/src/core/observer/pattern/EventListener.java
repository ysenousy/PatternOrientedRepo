package core.observer.pattern;

import java.io.File;

public interface EventListener {
    void update(String eventType, File file);
}

