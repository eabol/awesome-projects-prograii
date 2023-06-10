package views;

import models.MachineModel;
import utils.Line;

import java.util.List;
import java.util.Scanner;

public class MachineView {
    static Scanner input = new Scanner(System.in);
    private Line line;

    public MachineView(Line line) {
        this.line = line;
    }

    public void printMachineName(List<MachineModel> machines) {
        line.printLine();

        machines.forEach(machine -> {
            final int width = 28;
            final int padding = (width - machine.showName().length()) / 2;
            System.out.print(
                String.format("%" + padding + "s%s%" + padding + "s", "", machine.showName(), "")
            );
        });

        line.printLineByMachines(machines);
    }
}
