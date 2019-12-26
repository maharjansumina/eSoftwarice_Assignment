package com.softwarica.esoftwarice_assignment.Model;

public class Students {

    private int imageId;
    private String fullname;
    private String gender;
    private int age;
    private String address;

    public Students(String fullname, String gender, int age, String address) {
        this.imageId = imageId;
        this.fullname = fullname;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}






