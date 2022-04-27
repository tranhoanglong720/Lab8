package com.example.lab81;

public class User {
    private String name;
    private String email;
    private String pass;
    private String pass2;
    public int normal;
    public int happy;
    public int unhappy;


    public User(String name, String email, String pass, String pass2, int normal, int happy, int unhappy) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.pass2 = pass2;
        this.normal = normal;
        this.happy = happy;
        this.unhappy = unhappy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    public int getNormal() {
        return normal;
    }

    public void setNormal(int normal) {
        this.normal = normal;
    }

    public int getHappy() {
        return happy;
    }

    public void setHappy(int happy) {
        this.happy = happy;
    }

    public int getUnhappy() {
        return unhappy;
    }

    public void setUnhappy(int unhappy) {
        this.unhappy = unhappy;
    }


    public User(){

    }

}
