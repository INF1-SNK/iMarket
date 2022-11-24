package fr.pantheonsorbonne.ufr27.miage.dto;

public class CvDTO {
    String firstName;
    String lastName;
    String localisation;
    Integer age;
    String  contractType;
    Integer weeklyHours;
    String email;

    public CvDTO(String firstName, String lastName, String localisation, Integer age, String contractType, Integer weeklyHours, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.localisation = localisation;
        this.age = age;
        this.contractType = contractType;
        this.weeklyHours = weeklyHours;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public Integer getWeeklyHours() {
        return weeklyHours;
    }

    public void setWeeklyHours(Integer weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
