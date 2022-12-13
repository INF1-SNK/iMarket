package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.EmployeeDAO;
import fr.pantheonsorbonne.ufr27.miage.dao.EmployeeDAOImpl;
import fr.pantheonsorbonne.ufr27.miage.dto.CvDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.EmployeeDTO;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class EmployeeServiceImpl implements EmployeeService {

    @Inject
    CandidatureService candidatureService;

    @Inject
    EmployeeDAO employeeDAO;


    @Override
    public Boolean createEmployee() {
        if(candidatureService.sendCandidatAccepted().isEmpty()){
            return false;
        }
        else {
            for (CvDTO cv : candidatureService.sendCandidatAccepted()) {
                employeeDAO.add(cv.getFirstName(), cv.getLastName(), cv.getAge(), cv.getContractType(), cv.getWeeklyHours(), "morning", cv.getLocalisation());
            }
            return true;
        }

    }
}
