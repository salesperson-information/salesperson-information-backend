package olivertuesta.com.salesperson.service.impl;

import olivertuesta.com.salesperson.model.Salesperson;
import olivertuesta.com.salesperson.repository.SalespersonRepository;
import olivertuesta.com.salesperson.service.SalespersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SalespersonServiceImpl implements SalespersonService {

    @Autowired
    private SalespersonRepository salespersonRepository;


    @Override
    public List<Salesperson> findAll() {
        return salespersonRepository.findAll();
    }

    @Override
    public Salesperson findById(Long id) {
        return salespersonRepository.findById(id).orElse(null);
    }

    @Override
    public Salesperson save(Salesperson salesperson) {
        return salespersonRepository.save(salesperson);
    }

    @Override
    public void deleteById(Long id) {
        salespersonRepository.deleteById(id);
    }

    @Override
    public Salesperson update(Salesperson salesperson) {
        return salespersonRepository.save(salesperson);
    }

    @Override
    public List<Salesperson> findByNameContainingIgnoreCase(String name) {
        return salespersonRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Salesperson> findByRegistrationNumberContainingIgnoreCase(String registrationNumber) {
        return salespersonRepository.findByRegistrationNumberContainingIgnoreCase(registrationNumber);
    }

    @Override
    public List<Salesperson> findByEstateAgentNameContainingIgnoreCase(String estateAgentName) {
        return salespersonRepository.findByEstateAgentNameContainingIgnoreCase(estateAgentName);
    }

    @Override
    public List<Salesperson> findByEstateAgentLicenseNumberContainingIgnoreCase(String estateAgentLicenseNumber) {
        return salespersonRepository.findByEstateAgentLicenseNumberContainingIgnoreCase(estateAgentLicenseNumber);
    }

    @Override
    public List<Salesperson> findByRegistrationStartDateBetween(LocalDate startDate, LocalDate endDate) {
        return salespersonRepository.findByRegistrationStartDateBetween(startDate, endDate);
    }

    @Override
    public List<Salesperson> findByRegistrationEndDateBetween(LocalDate startDate, LocalDate endDate) {
        return salespersonRepository.findByRegistrationEndDateBetween(startDate, endDate);
    }
}
