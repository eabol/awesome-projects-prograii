package main.core.login;

import main.core.Worker;
import main.core.data.Data;
import main.utils.FileWriter;

public class Manager extends FileWriter {

    private Worker employee;
    private Data data;
    public Manager() {
        data = new Data();
    }

    private String newIdEmployee() {

        String idEmployee;

        if (data.workerData().size() > 0) {
            int last = data.workerData().size() - 1;
            String id = data.workerData().get(last).getIdEmployee();
            String[] numbers = id.split("-");
            int newId = Integer.parseInt(numbers[1]) + 1;
            idEmployee = "EMP-" + newId;
        } else {
            idEmployee = "EMP-0";
        }

        return idEmployee;
    }

    public void userCreate(String username, String password, String email, String dep) {
        employee = new Worker(newIdEmployee(), username, password, email, "Naturgy", dep);
        writeWorkersData(employee);
        System.out.println("Successfully registered user");
    }

    public boolean login(String username, String password) {
        for (Worker employee : data.workerData()) {
            if (employee.getName().equalsIgnoreCase(username) && employee.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }



}
