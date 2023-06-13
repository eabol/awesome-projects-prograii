package vacuum;

public class VacuumMain {

    public static void main(String[] args) {

        Board map1 = new Board(10, 25);
        map1.generateMap();
        map1.addFurniture();

        VacuumCleaner P1 = new VacuumCleaner(5,12,5,0,30,900,900,0,true);
        Cat C1 = new Cat(6,6,6,true, false);

        Controller.printHeader(P1,C1, map1);
        map1.printMap(P1,C1);
        Controller.gameKeys(P1,map1);

    }





}

