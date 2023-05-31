package Main;

public  class Well {
    private Snail snail;
    private final int depth;
    public int waterDepth=-20;

    public int getWaterDepth() {
        return waterDepth;
    }

    public void setWaterDepth(int waterDepth) {
        this.waterDepth = waterDepth;
    }

    public Well() {
        this.depth = -20;
        this.snail = new Snail();
    }

    public void survive() throws Death {
        boolean isAlive = true;
        while (isAlive) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (waterDepth >= this.snail.getAltitude()) {
                isAlive = false;
                throw new Death("Main.Snail is dead");
            }

            System.out.println();

        }

    }


}


