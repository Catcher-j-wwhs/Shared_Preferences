package com.example.sharedpreferences;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String firstName;
    private int age;
    private String Mail;
    private Adress mAdress;
    private ArrayList<FamilyMember> mFamilymember;

    public Employee(String name , int age , String Mail , Adress Adress, ArrayList<FamilyMember> fam)

    {
        firstName = name;
        this.age = age;
        this.Mail = Mail;
        mAdress = Adress;
        mFamilymember = fam;

    }
}
