public class Well {
    private Snail snail;
    private final int depth;
    public int waterDepth;

    public Well() {
        this.depth = -20;
        this.waterDepth = -20;
        this.snail = new Snail();
    }

    public void survive() throws Death {
        boolean isAlive = true;
        Rain rain = new Rain("Is raining");
        while (isAlive) {
            snail.nextDay();
            int r = rain.succes();
            this.waterDepth += r;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (this.waterDepth >= this.snail.getAltitude()) {
                isAlive = false;
                throw new Death("Snail is dead");
            }
            System.out.println();

        }

    }


}


