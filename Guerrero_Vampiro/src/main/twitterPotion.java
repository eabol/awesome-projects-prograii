package main;

public class twitterPotion extends potions{

    public twitterPotion (String name, int cuantity){
        super(name, cuantity);
    }
    public boolean activatetwitterPotion() {
        return twitterActive = true;
    }
    public boolean deactivatetwitterPotion() {
        return twitterActive = false;
    }
    public void twitterEssence(warrior character){
        activatetwitterPotion();
        double counter = 0;
        double health = character.getHealth();
        System.out.println("You have used a Attack Potion. All your weapons will now deal more damage!");
        while (counter <=2){
            counter++;
            System.out.println("You feel the effects of the potion fading away...");
        }
        if (counter ==2){
            if (health !=0){
                deactivatetwitterPotion();
                System.out.println("The effects of the potion have faded away");
            }else {
                System.out.println("You are dead, the effects of the potion won't work on you.");
            }
        }
    }
}
