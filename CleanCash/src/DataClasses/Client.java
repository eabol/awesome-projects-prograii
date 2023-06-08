package DataClasses;

public class Client extends Entity {
    private String phoneNumber;
    private int pointsBalance;

    public int getPointsBalance() {
        return pointsBalance;
    }

    public void setPointsBalance(int pointsBalance) {
        this.pointsBalance = pointsBalance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Client(String entityName, String entityId) {
        super(entityName, entityId);
    }

    @Override
    public boolean compare (Entity entity) {
        super.compare(entity);
        if (entity instanceof Client){
            Client client = (Client) entity;
            if (client.getEntityId() == this.getEntityId()){
                return true;
            }
            else if (client.getPhoneNumber() == this.getPhoneNumber()){
                return true;
            }
            else return false;
        }
        else return false;
    }


    public void addBalance(float expended){
        int addedPoints = (int)(expended/100);
        int newBalance = getPointsBalance() + addedPoints;
        setPointsBalance(newBalance);
    }
}
