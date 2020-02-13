package com.emon535.emplmanagement.model;

import com.emon535.emplmanagement.utils.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.UUID;


public class Employee {
    @JsonProperty("id") private UUID id;
    @JsonProperty("name") @NotBlank private  String name;
    @JsonProperty("contractNumber") @Pattern(
            regexp = "^(?:\\+88|01)?\\d{11}$",
            message = "Must be Bangladeshi Mobile Number."
    )  private String contractNumber;
    @JsonProperty("email")  @Email(message = "Enter a valid email address.") private   String email;
    @JsonProperty("gender") private   Gender gender;
    @JsonProperty("birthday") private  String birthday;
    @JsonProperty("imagePath")     private  String imagePath;
    @JsonProperty("programmingLanguage") private   String [] programmingLanguage;
    @JsonProperty("presentAddress") private   String presentAddress;



    public Employee(
             UUID id,
             String name,
             String contractNumber,
             String email,
             Gender gender,
             String birthday,
             String imagePath,
             String[] programmingLanguage,
             String presentAddress
                    ) {
        this.id = id;
        this.name = name;
        this.contractNumber = contractNumber;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
        this.imagePath = imagePath;
        this.programmingLanguage = programmingLanguage;
        this.presentAddress = presentAddress;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String[] getProgrammingLanguage() {
        return programmingLanguage;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setProgrammingLanguage(String[] programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }
}
