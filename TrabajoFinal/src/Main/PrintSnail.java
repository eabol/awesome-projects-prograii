package Main;

public class PrintSnail {
    public static void dibujaPozo(int profundidadPozo, int profundidadAgua, int profundidadCaracol, Warning... warnings) {
        for (int i = 0; i >= -20; i=i-1) {
            if(i==0&&Warning.CAR_PASS==warnings[0]){
                System.out.println("  []    O-=-O     []");
            }else if (i == 0) {
                System.out.println("  []              []");
            } else if (i <= profundidadAgua) {
                System.out.println("  []~~~~~~~~~~~~~~[]" + i);
            } else if (i == profundidadCaracol&&Warning.FALL_LEAF==warnings[1]) {
                System.out.println("  []    _@)_/’  * []" + i);
            } else if (i == profundidadCaracol) {
                System.out.println("  []    _@)_/’    []" + i);
            } else {
                System.out.println("  []:. :. :. :. :.[]" + i);
            }
        }
        System.out.println("  [][][][][][][][][] ");
        System.out.println("\n");
    }

}

