package DataClasses;

public class Member extends Entity {
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

    public Member(String entityName, String entityId, String phoneNumber) {
        super(entityName, entityId);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean compare (Entity entity) {
        super.compare(entity);
        if (entity instanceof Member){
            Member member = (Member) entity;
            if (member.getEntityId() == this.getEntityId()){
                return true;
            }
            else if (member.getPhoneNumber() == this.getPhoneNumber()){
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
