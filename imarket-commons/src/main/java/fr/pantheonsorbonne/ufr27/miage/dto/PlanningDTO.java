package fr.pantheonsorbonne.ufr27.miage.dto;


import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlRootElement
public class PlanningDTO {
    int planningId;
    int totalHours;
    int morningHours;
    int eveningHours;
    int nbMorningEmployees;
    int nbEveningEmployees;

    public Collection<EmployeeDTO> getEmployeeDTOCollection() {
        return employeeDTOCollection;
    }

    public void setEmployeeDTOCollection(Collection<EmployeeDTO> employeeDTOCollection) {
        this.employeeDTOCollection = employeeDTOCollection;
    }

    Collection<EmployeeDTO> employeeDTOCollection;
    String city;

    public PlanningDTO(int planningId, int totalHours, int morningHours, int eveningHours, int nbMorningEmployees, int nbEveningEmployees, Collection<EmployeeDTO> employeeDTOCollection) {
        this.planningId = planningId;
        this.totalHours = totalHours;
        this.morningHours = morningHours;
        this.eveningHours = eveningHours;
        this.nbMorningEmployees = nbMorningEmployees;
        this.nbEveningEmployees = nbEveningEmployees;
        this.employeeDTOCollection = employeeDTOCollection;
        this.city = "Paris";
    }

    public PlanningDTO() {
    }

    public int getPlanningId() {
        return planningId;
    }

    public void setPlanningId(int planningId) {
        this.planningId = planningId;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public int getMorningHours() {
        return morningHours;
    }

    public void setMorningHours(int morningHours) {
        this.morningHours = morningHours;
    }

    public int getEveningHours() {
        return eveningHours;
    }

    public void setEveningHours(int eveningHours) {
        this.eveningHours = eveningHours;
    }
    public String getCity() { return city;}
    public int getNbMorningEmployees() {
        return nbMorningEmployees;
    }

    public void setNbMorningEmployees(int nbMorningEmployees) {
        this.nbMorningEmployees = nbMorningEmployees;
    }

    public int getNbEveningEmployees() {
        return nbEveningEmployees;
    }

    public void setNbEveningEmployees(int nbEveningEmployees) {
        this.nbEveningEmployees = nbEveningEmployees;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
