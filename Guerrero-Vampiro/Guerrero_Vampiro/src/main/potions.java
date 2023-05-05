package main;

public class potions extends Equipment {

    public potions(String name, int cuantity) {
        super(name, cuantity);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCuantity(int cuantity) {
        this.cuantity = cuantity;
    }

    public String getName() {
        return this.name;
    }

    public int getCuantity() {
        return this.cuantity;
    }

    public void berserkPotion(warrior character) {
        int health = character.getHealth()+10;
        character.setHealth(health);
        int defense = character.getDefense()+10;
        character.setDefense(defense);
        int accuracy = character.getAccuracy()+10;
        character.setAccuracy(accuracy);
        int berserkPotion = this.cuantity-1;
        int counter = 0;
        System.out.println("You have used a Berserk Potion on " + character.getName()+ "and now his stats are: "+ "Health: "+ character.getHealth()+ " Defense: "+ character.getDefense()+ " Accuracy: "+ character.getAccuracy());
        while (counter <=3){
            counter++;
            System.out.println("You feel the effects of the potion fading away...");
        }
        if (counter ==3){
            character.setHealth(health-20);
            character.setDefense(defense-10);
            character.setAccuracy(accuracy-10);
            System.out.println("The effects of the potion have faded away, your stats are now: "+ "Health: "+ character.getHealth()+ " Defense: "+ character.getDefense()+ " Accuracy: "+ character.getAccuracy());
        }
    }
    public void healthPotion(warrior character) {
        int health = character.getHealth()+10;
        character.setHealth(health);
        int healthPotion = this.cuantity-1;
        int counter = 0;
        System.out.println("You have used a Health Potion on " + character.getName()+ "and now his health is: "+ character.getHealth());
        while (counter <=3){
            counter++;
            System.out.println("You feel the effects of the potion fading away...");
        }
        if (counter ==3){
            if (health !=0){
                character.setHealth(health+20);
                System.out.println("The effects of the potion have faded away, your health is now: "+ character.getHealth());
            }else {
                System.out.println("You are dead, the effects of the potion won't work on you.");
            }
        }

    }
    public void glassPotion(warrior character) {
        int counter = 0;
        int health = character.getHealth()+10;
        while (counter <=3){
            counter++;
            System.out.println("You feel the effects of the potion fading away...");
        }
        if(counter ==3){
            if (health !=0){
                character.setDefense(character.getDefense()*2);
                System.out.println("The effects of the potion have faded away, your health is now: "+ character.getHealth());
            }else {
                System.out.println("You are dead, the effects of the potion won't work on you.");
            }
        }

    }
    public void seagullEye(warrior character) {
        int accuracy = (int) (character.getAccuracy()+(character.getAccuracy()*0.25));
        character.setAccuracy(accuracy);
        int accuracyPotion = this.cuantity-1;
        int counter = 0;
        int health = character.getHealth()+10;
        System.out.println("You have used a Accuracy Potion on " + character.getName()+ "and now his accuracy is: "+ character.getAccuracy());
        while (counter <=3){
            counter++;
            System.out.println("You feel the effects of the potion fading away...");
        }
        if (counter ==3){
            if (health !=0){
                character.setAccuracy((int) (accuracy-(character.getAccuracy()*0.25)));
                System.out.println("The effects of the potion have faded away, your accuracy is now: "+ character.getAccuracy());
            }else {
                System.out.println("You are dead, the effects of the potion won't work on you.");
            }
        }

    }
    public void twitterEssence(warrior character){
        int attack = character.getAttack()+8;
        character.setAttack(attack);
        int attackPotion = this.cuantity-1;
        int counter = 0;
        int health = character.getHealth();
        System.out.println("You have used a Attack Potion on " + character.getName()+ "and now his attack is: "+ character.getAttack());
        while (counter <=2){
            counter++;
            System.out.println("You feel the effects of the potion fading away...");
        }
        if (counter ==2){
            if (health !=0){
                character.setAttack(attack-8);
                System.out.println("The effects of the potion have faded away, your attack is now: "+ character.getAttack());
            }else {
                System.out.println("You are dead, the effects of the potion won't work on you.");
            }
        }
    }
}

