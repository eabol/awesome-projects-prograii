package main;
    public class Weapons {
        private int damage;
        private double accuracy;

        public Weapons(int damage, double accuracy) {
            this.damage = damage;
            this.accuracy = accuracy;
        }

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public double getAccuracy() {
            return accuracy;
        }

        public void setAccuracy(double accuracy) {
            this.accuracy = accuracy;
        }


//Weapons sword = new Weapons(7, 50);
//Weapons handaxe = new Weapons(15, 25);
//Weapons flail = new Weapons(30, 12);
//Weapons bite = new Weapons(5, 90);
//Weapons scratch = new Weapons(10, 60);
//Weapons soulsiphon = new Weapons(20, 40);
//Weapons shield = new Weapons(0, 80);

}