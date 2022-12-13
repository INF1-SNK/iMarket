package fr.pantheonsorbonne.ufr27.miage.dto;

import java.util.Objects;


public class EmployeeDTO {
    private String familyName;
    private String firstName;
    private Integer age;

    private String contractType;
    private Integer weeklyHours;

    private String timeOfDay;

    private String position;

    public EmployeeDTO(String familyName,  String firstName, Integer age, String contractType, Integer weeklyHours, String timeOfDay, String position) {
        this.familyName = familyName;
        this.firstName = firstName;
        this.age = age;
        this.contractType = contractType;
        this.weeklyHours = weeklyHours;
        this.timeOfDay = timeOfDay;
        this.position = position;
    }

    public EmployeeDTO() {
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getFirstName() { return firstName;}

    public Integer getAge() {
        return age;
    }

    public String getContractType() {
        return contractType;
    }

    public Integer getWeeklyHours() {
        return weeklyHours;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO entity = (EmployeeDTO) o;
        return Objects.equals(this.familyName, entity.familyName) &&
                Objects.equals(this.age, entity.age) &&
                Objects.equals(this.contractType, entity.contractType) &&
                Objects.equals(this.weeklyHours, entity.weeklyHours) &&
                Objects.equals(this.timeOfDay, entity.timeOfDay) &&
                Objects.equals(this.position, entity.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyName, age, contractType, weeklyHours, timeOfDay, position);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "familyName = " + familyName + ", " +
                "age = " + age + ", " +
                "contractType = " + contractType + ", " +
                "weeklyHours = " + weeklyHours + ", " +
                "timeOfDay = " + timeOfDay + ", " +
                "position = " + position + ")";
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public void setWeeklyHours(Integer weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setFirstName(String firstName) { this.firstName = firstName; }

}