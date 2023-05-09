package main;

public class potions extends Equipment {

    public boolean potionActive = false;
    public potions(String name, int cuantity) {
        super(name, cuantity);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCuantity(int cuantity) {
        this.cuantity = cuantity;
    }

    public boolean activatePotion() {
        return this.potionActive = true;
    }
    public boolean deactivatePotion() {
        return this.potionActive = false;
    }

    public boolean isPotionActive() {
        return potionActive;
    }

    public String getName() {
        return this.name;
    }

    public double getCuantity() {
        return this.cuantity;
    }

    //cambiar precision
    public void berserkPotion(warrior character) {
        activatePotion();
        double health = character.getHealth()*1.5;
        character.setHealth(health);
        double defensebase = character.getDefense();
        double defense = character.getDefense()*1.5;
        character.setDefense(defense);
        double accuracy = character.getAccuracy()*1.5;
        character.setAccuracy(accuracy);
        double berserkPotion = this.cuantity-1;
        double counter = 0;
        System.out.println("You have used a Berserk Potion, your stats are: "+ "Health: "+ character.getHealth()+ " Defense: "+ character.getDefense()+ " Accuracy: "+ character.getAccuracy());
        while (counter <=3){
            counter++;
            System.out.println("You feel the effects of the potion fading away...");
        }
        if (counter ==3){
            deactivatePotion();
            character.setHealth(health-20);
            character.setDefense(defensebase);
            character.setAccuracy(accuracy-10);
            System.out.println("The effects of the potion have faded away, your stats are now: "+ "Health: "+ character.getHealth()+ " Defense: "+ character.getDefense()+ " Accuracy: "+ character.getAccuracy());
        }
    }
    public void healthPotion(warrior character) {
        activatePotion();
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
                deactivatePotion();
                character.setHealth(health+20);
                System.out.println("The effects of the potion have faded away, your health is now: "+ character.getHealth());
            }else {
                System.out.println("You are dead, the effects of the potion won't work on you.");
            }
        }

    }
    public void rockSolid(warrior character) {
        activatePotion();
        double counter = 0;
        double health = character.getHealth();
        while (counter <=3){
            counter++;
            System.out.println("You feel the effects of the potion fading away...");
        }
        if(counter ==3){
            if (health !=0){
                deactivatePotion();
                character.setDefense(character.getDefense()*2);
                System.out.println("The effects of the potion have faded away, your health is now: "+ character.getHealth());
            }else {
                System.out.println("You are dead, the effects of the potion won't work on you.");
            }
        }

    }
    public void seagullEye(warrior character) {
        activatePotion();
        double accuracy = (double) (character.getAccuracy()+(character.getAccuracy()*0.25));
        character.setAccuracy(accuracy);
        double accuracyPotion = this.cuantity-1;
        double counter = 0;
        double health = character.getHealth()+10;
        System.out.println("You have used a Accuracy Potion on " + character.getName()+ "and now his accuracy is: "+ character.getAccuracy());
        while (counter <=3){
            counter++;
            System.out.println("You feel the effects of the potion fading away...");
        }
        if (counter ==3){
            if (health !=0){
                deactivatePotion();
                character.setAccuracy((double) (accuracy-(character.getAccuracy()*0.25)));
                System.out.println("The effects of the potion have faded away, your accuracy is now: "+ character.getAccuracy());
            }else {
                System.out.println("You are dead, the effects of the potion won't work on you.");
            }
        }

    }
    public void twitterEssence(warrior character){
        activatePotion();
        double attack = character.getAttack()+8;
        character.setAttack(attack);
        double attackPotion = this.cuantity-1;
        double counter = 0;
        double health = character.getHealth();
        System.out.println("You have used a Attack Potion on " + character.getName()+ "and now his attack is: "+ character.getAttack());
        while (counter <=2){
            counter++;
            System.out.println("You feel the effects of the potion fading away...");
        }
        if (counter ==2){
            if (health !=0){
                deactivatePotion();
                character.setAttack(attack-8);
                System.out.println("The effects of the potion have faded away, your attack is now: "+ character.getAttack());
            }else {
                System.out.println("You are dead, the effects of the potion won't work on you.");
            }
        }
    }
}

