package utils;

public class Line {
    private int length;

    public Line(int length) {
        this.length = length;
    }

    public void printLine() {
        String line = "_".repeat(this.length);
        System.out.println(line);
    }

    public void printLineByMachines(java.util.List<models.MachineModel> machines) {
        System.out.print("\n|__________________________|");
        for(int j=0;j<machines.size() -1;j++)
        {
            System.out.print("___________________________|");            
        }
        System.out.println();
    }

    public void printLineOfHyphens() {
        String hyphens = "-".repeat(this.length);
        System.out.println(hyphens);
    }

    public void printDoubleLine() {
        String equal = "=".repeat(this.length);
        System.out.println(equal);
    }
}
