package main;

public class malhitePotion extends potions{
    public malhitePotion(String name, int cuantity) {
        super(name, cuantity);
    }

    public boolean activaterockPotion() {
        return rockActive = true;
    }
    public boolean deactivaterockPotion() {
        return rockActive = false;
    }

    public void rockSolid(warrior character) {
        activaterockPotion();
        double counter = 0;
        double health = character.getHealth();
        System.out.println("You have consumed the defense potion. The vampire will deal less damage now");
        while (counter <=3){
            counter++;
            System.out.println("You feel the effects of the potion fading away...");
        }
        if(counter ==3){
            if (health !=0){
                deactivaterockPotion();;
                System.out.println("The effects of the potion have faded away, your health is now: "+ character.getHealth());
            }else {
                System.out.println("You are dead, the effects of the potion won't work on you.");
            }
        }

    }
}
