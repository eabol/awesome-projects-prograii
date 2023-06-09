package main.core;

import main.core.login.User;

public class Worker extends User {

    private String idEmployee;
    private String email;
    private String nameCompany;
    private String department;

    public Worker(String idEmployee, String name, String password, String email, String nameCompany, String department) {
        super(name, password);
        this.idEmployee = idEmployee;
        this.email = email;
        this.nameCompany = nameCompany;
        this.department = department;
    }

    public Worker() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "idEmployee='" + idEmployee + '\'' +
                ", email='" + email + '\'' +
                ", nameCompany='" + nameCompany + '\'' +
                ", area='" + department + '\'' +
                '}';
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
