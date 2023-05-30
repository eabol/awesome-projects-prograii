package main;

public class lastBreathPotion extends potions{

    public lastBreathPotion(String name, int cuantity) {
        super(name, cuantity);
    }

    public boolean activatelastBreathPotion() {
        return healthActive = true;
    }
    public boolean deactivatelastBreathPotion() {
        return healthActive = false;
    }

    public void lastBreath(warrior character) {
        activatelastBreathPotion();
        double health = character.getHealth()+10;
        character.setHealth(health);
        double healthPotion = this.cuantity-1;
        double counter = 0;
        System.out.println("You have used a Health Potion on " + character.getName()+ "and now his health is: "+ character.getHealth());
        while (counter <=3){
            counter++;
            System.out.println("You feel the effects of the potion fading away...");
        }
        if (counter ==3){
            if (health !=0){
                deactivatelastBreathPotion();
                character.setHealth(health+20);
                System.out.println("The effects of the potion have faded away, your health is now: "+ character.getHealth());
            }else {
                System.out.println("You are dead, the effects of the potion won't work on you.");
            }
        }

    }
}
