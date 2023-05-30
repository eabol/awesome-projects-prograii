package main;

public class seagullPotion  extends potions{
    public seagullPotion(String name, int cuantity) {
        super(name, cuantity);
    }
    public boolean activateeyePotion() {
            return eyeActive = true;
    }
    public boolean deactivateeyePotion() {
        return eyeActive = false;
    }
    public void seagullEye(warrior character) {
        activateeyePotion();
        double accuracyPotion = this.cuantity-1;
        double counter = 0;
        double health = character.getHealth();
        System.out.println("You have used a Accuracy Potion. Your attacks will now be more likely to hit the vampire");
        while (counter <=3){
            counter++;
            System.out.println("You feel the effects of the potion fading away...");
        }
        if (counter ==3){
            if (health !=0){
                deactivateeyePotion();
                System.out.println("The effects of the potion have faded away, your accuracy has returned to normal values");
            }else {
                System.out.println("You are dead, the effects of the potion won't work on you.");
            }
        }

    }
}
