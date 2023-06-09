package Main;

public class Well implements InterfaceWell {

    private Snail snail;

    public int waterDepth = -20;

    @Override
    public int depth() {
        return -20;
    }

    public int getWaterDepth() {
        return waterDepth;
    }


    public void setWaterDepth(int waterDepth) {
        this.waterDepth = waterDepth;
    }


    public void survive() throws Death {
        boolean isAlive = true;
        while (isAlive) {

            if (waterDepth >= this.snail.getAltitude()) {
                isAlive = false;
                throw new Death();
            }

            System.out.println();

        }

    }

}



