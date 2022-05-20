package ru.netology;

import lombok.Data;

@Data public class  ApplicantData {
    private String city;
    private String appointmentDate;
    private String fullName;
    private String phone;
    
    public ApplicantData(String city, String fullName, String phone) {
        this.city = city;
        this.fullName = fullName;
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }
}
