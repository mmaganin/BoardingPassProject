package com.gensparkproj.boardingpass.Entity;

import com.gensparkproj.boardingpass.Entity.BoardingPass;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="tbl_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cus_id;

    @Column(name = "phone_num")
    String phoneNum;

    @Column(name = "boarding_passes")
    ArrayList<Integer> boardingPassesIds;

    int name;
    int age;
    String email;
    String gender;

    public int getCus_id() {
        return cus_id;
    }

    public void setCus_id(int cus_id) {
        this.cus_id = cus_id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public ArrayList<Integer> getBoardingPassesIds() {
        return boardingPassesIds;
    }

    public void setBoardingPassesIds(ArrayList<Integer> boardingPassesIds) {
        this.boardingPassesIds = boardingPassesIds;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cus_id=" + cus_id +
                ", phoneNum='" + phoneNum + '\'' +
                ", boardingPassesIds=" + boardingPassesIds +
                ", name=" + name +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
