package vacuum;

public class VacuumMain {

    public static void main(String[] args) {

        Board map1 = new Board(10, 25);
        map1.generateMap();
        map1.addFurniture();
        map1.setTotalDirt();
        VacuumCleaner P1 = new VacuumCleaner(5,12,5,0,30,900,900,0,true);
        Cat C1 = new Cat(6,12,5,true, false);

        do {
            Controller.printHeader(P1, C1, map1);
            map1.printMap(P1, C1);
            Controller.gameKeys(P1, map1);
            P1.clean(map1, map1.map);
            Controller.felineActivity(C1, map1);
        } while (Controller.checkGameState(P1,C1,map1));
    }





}

