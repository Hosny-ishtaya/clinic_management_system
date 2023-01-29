/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxlogin;

/**
 *
 * @author Msys
 */
public class doc_table {
    String username,password,joinD,leavD;
    int salary,id;

    public doc_table() {
        this.username = "user";
        this.password = "pass";
        this.joinD = "jd";
        this.leavD = "ld";
        this.salary = 0;
        this.id = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJoinD() {
        return joinD;
    }

    public void setJoinD(String joinD) {
        this.joinD = joinD;
    }

    public String getLeavD() {
        return leavD;
    }

    public void setLeavD(String leavD) {
        this.leavD = leavD;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
