package com.projectindigo.case_study_android_apps;

import java.util.Date;

/**
 * Created by Nicolas on 17/06/2017.
 */

public class Visitor {
    String firstName, lastName, email, address, company, rego;
    int phone;
    Date createDate; //dunno yet

    public Visitor(String firstName, String lastName, String email, String address, String company, String rego, int phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.company = company;
        this.rego = rego;
        this.phone = phone;
    }
}
