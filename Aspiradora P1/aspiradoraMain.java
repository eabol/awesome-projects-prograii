public class aspiradoraMain {

    //mapa
    private int[][] map;


    public aspiradoraMain() {
        //tamaño del mapa
        map = new int[10][25];
        generateMap();
    }

    //generador de mapa
    private void generateMap() {
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[row].length; column++) {
                //bordes
                if ((row==0 || row==map.length-1)&&(column==0 || column==map[row].length-1)){
                    map[row][column] = 7;
                } else
                if ((row==0 || row==map.length-1)){
                    map[row][column] = 9;
                } else 
                if ((column==0 || column==map[row].length-1)){
                    map[row][column] = 8;
                } else
                //generacion de suciedad, 50% de probabilidad y niveles de 1-4
                if (((int)(Math.random()*100) + 1 > 50)){
                    map[row][column] = (int)(Math.random()*4 +1);
                }

            }
        }
    }

    //impresion del mapa
    public void printMap() {
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[row].length; column++) {
                System.out.print(map[row][column] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        aspiradoraMain demo = new aspiradoraMain();
        demo.printMap();
    }




}