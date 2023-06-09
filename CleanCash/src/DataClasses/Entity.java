package DataClasses;

public abstract class Entity {
    private String entityName;
    private String entityId;
    public String getEntityName() {
        return entityName;
    }
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
    public String getEntityId() {
        return entityId;
    }
    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public Entity(String entityName, String entityId) {
        this.entityName = entityName;
        this.entityId = entityId;
    }

    public boolean compare(Entity entity){
        if (entity.getEntityId() == this.getEntityId()){
            return true;
        }
        else return false;
    }


}
