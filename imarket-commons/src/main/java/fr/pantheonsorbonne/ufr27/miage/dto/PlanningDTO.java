package fr.pantheonsorbonne.ufr27.miage.dto;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PlanningDTO {
    int planningId;
    int totalHours;
    int morningHours;
    int eveningHours;

    String city;

    public PlanningDTO(int planningId, int totalHours, int morningHours, int eveningHours) {
        this.planningId = planningId;
        this.totalHours = totalHours;
        this.morningHours = morningHours;
        this.eveningHours = eveningHours;
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
}
