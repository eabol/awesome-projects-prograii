package SystemManagement;

import DataClasses.Entity;

public interface DataManager {
    void add(Entity newEntity);
    void remove(Entity removedEntity);
    void identify(Entity entity);
}
