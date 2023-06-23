package main;

public class WarriorActions extends main.Warrior {

    public WarriorActions(){
        super("0", 0);
    }

    Flail attackFlail = new Flail(30, 12);
    Sword attackSword = new Sword(7, 50);
    Handaxe attackHandaxe = new Handaxe(15, 25);
    DaggThrow attackDagger = new DaggThrow(20, 18);

    main.Warrior Warrior = new Warrior("Warrior", 100);

    SmokeBomb smokeBomb = new SmokeBomb("Smoke Bomb", 1);
    Intimidate intimidate = new Intimidate(0,14);






    public void attackFlail(){
        attackFlail.setDamage(30);
        attackFlail.setAccuracy(12);
        attackFlail.FlailAttack(30, 12);
        attackFlail.hit();
    }
    public void attackSword(){
        attackSword.setDamage(7);
        attackSword.setAccuracy(50);
        attackSword.swordAttack(7, 50);
        attackSword.hit();
    }
    public void attackHandaxe(){
        attackHandaxe.setDamage(15);
        attackHandaxe.setAccuracy(25);
        attackHandaxe.handaxeAttack(15, 25);
        attackHandaxe.hit();
    }



    public void attackDagger(){
        attackDagger.setDamage(20);
        attackDagger.setAccuracy(18);
        attackDagger.DaggThrowAttack(20, 18);
        attackDagger.hit();
    }

    public void NigerunDayo(){
        System.out.println("You used Smoke Bomb!");
        smokeBomb.hit();
    }

    public void Spooky(){
        intimidate.setDamage(0);
        intimidate.setAccuracy(14);
        intimidate.SpookyAttack(0, 14);
        intimidate.hit();

    }


}

