package main;

public class berserkPotion extends potions{
    public berserkPotion(String name, int cuantity) {
        super(name, cuantity);
    }
    public boolean activateberserkPotion() {
        return berserkActive = true;
    }
    public boolean deactivateberserkPotion() {
        return berserkActive = false;
    }
    public void berserkPotion( warrior character) {
        activateberserkPotion();
        boolean berserkActive = true;
        double health = character.getHealth()*1.5;
        character.setHealth(health);
        double berserkPotion = this.cuantity-1;
        double counter1 = 0;
        System.out.println("You have used a Berserk Potion, your stats are: "+ "Health: "+ character.getHealth());
        while (counter1 <=3){
            counter1++;
            System.out.println("You feel the effects of the potion fading away...");
        }
        if (counter1 ==3){
            deactivateberserkPotion();
            character.setHealth(health-20);
            System.out.println("The effects of the potion have faded away, your stats are now: "+ "Health: "+ character.getHealth());
        }
    }
}
