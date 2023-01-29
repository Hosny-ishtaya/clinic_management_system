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
public class Clinic_table {
    
public String Name_of_clinics,Doctors_work_in;
      public  int id;
 

public Clinic_table(){
this.Name_of_clinics="clinic";
this.Doctors_work_in="doctor";
this.id=1;
}

    public String getName_of_clinics() {
        return Name_of_clinics;
    }

    public void setName_of_clinics(String Name_of_clinics) {
        this.Name_of_clinics = Name_of_clinics;
    }

    public String getDoctors_work_in() {
        return Doctors_work_in;
    }

    public void setDoctors_work_in(String Doctors_work_in) {
        this.Doctors_work_in = Doctors_work_in;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    
}
