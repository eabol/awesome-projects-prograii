public class Well {
    private Snail snail;
    private final int depth;
    public int waterDepth;
    public Well() {
        this.depth = -20;
        this.waterDepth=-20;
        this.snail=new Snail();
    }

    public void Survive() throws Alive {
        boolean isAlive = true;

        while (isAlive) {
            snail.nextDay();
            int rain = Rain.succes();
            this.waterDepth += rain;
            try {
                if (this.waterDepth <= this.snail.getAltitude()) {
                    throw new Death("Snail is dead");
                }
            } catch (Death d) {
                System.out.println(d.getMessage());
                isAlive = false;

            }
            if (this.snail.getAltitude()>=0) {
                throw new Alive("The snail is out");
            }

        }
    }
}


