package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "family_name")
    private String familyName;

    @Size(max = 50)
    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "age")
    private Integer age;

    @Size(max = 20)
    @Column(name = "contract_type", length = 20)
    private String contractType;

    @Column(name = "weekly_hours")
    private Integer weeklyHours;

    @Size(max = 20)
    @Column(name = "time_of_day", length = 20)
    private String timeOfDay;

    @ManyToMany
    @JoinTable(name = "Employee_Planning",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "planning_id"))
    private Set<Planning> plannings = new LinkedHashSet<>();

    @NotNull
    @Lob
    @Column(name = "position", nullable = false)
    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public Set<Planning> getPlannings() {
        return plannings;
    }

    public void setPlannings(Set<Planning> plannings) {
        this.plannings = plannings;
    }

}