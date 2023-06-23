package test.CORE;

import main.core.data.Worker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WorkerTest {

    @Test
    public void testGetEmail() {
        String email = "tecnico1@gmail.com";
        Worker worker = new Worker();
        worker.setEmail(email);
        Assertions.assertEquals(email, worker.getEmail());
    }

    @Test
    public void testSetEmail() {
        String email = "tecnico1@gmail.com";
        Worker worker = new Worker();
        worker.setEmail(email);
        Assertions.assertEquals(email, worker.getEmail());
    }

    @Test
    public void testToString() {
        String idEmployee = "EMP-234274";
        String email = "tecnico1@gmail.com";
        String nameCompany = "Naturgy";
        String department = "IT";
        Worker worker = new Worker(idEmployee, "Carlos", "1234", email, nameCompany, department);
        String expectedString = "Worker{" +
                "idEmployee='" + idEmployee + '\'' +
                ", email='" + email + '\'' +
                ", nameCompany='" + nameCompany + '\'' +
                ", area='" + department + '\'' +
                '}';
        Assertions.assertEquals(expectedString, worker.toString());
    }

    @Test
    public void testGetIdEmployee() {
        String idEmployee = "EMP-234274";
        Worker worker = new Worker(idEmployee, "Carlos", "1234", "tecnico1@gmail.com", "Naturgy", "1234");
        Assertions.assertEquals(idEmployee, worker.getIdEmployee());
    }

    @Test
    public void testSetIdEmployee() {
        String idEmployee = "EMP-234274";
        Worker worker = new Worker();
        worker.setIdEmployee(idEmployee);
        Assertions.assertEquals(idEmployee, worker.getIdEmployee());
    }

    @Test
    public void testGetNameCompany() {
        String nameCompany = "Naturgy";
        Worker worker = new Worker("EMP-234274", "Carlos", "1234", "tecnico1@gmail.com", nameCompany, "IT");
        Assertions.assertEquals(nameCompany, worker.getNameCompany());
    }

    @Test
    public void testSetNameCompany() {
        String nameCompany = "Naturgy";
        Worker worker = new Worker();
        worker.setNameCompany(nameCompany);
        Assertions.assertEquals(nameCompany, worker.getNameCompany());
    }

    @Test
    public void testGetDepartment() {
        String department = "IT";
        Worker worker = new Worker("EMP-234274", "Carlos", "1234", "tecnico1@gmail.com", "Naturgy", department);
        Assertions.assertEquals(department, worker.getDepartment());
    }

    @Test
    public void testSetDepartment() {
        String department = "IT";
        Worker worker = new Worker();
        worker.setDepartment(department);
        Assertions.assertEquals(department, worker.getDepartment());
    }
}
