package olivertuesta.com.salesperson.service;

import olivertuesta.com.salesperson.model.Salesperson;

import java.time.LocalDate;
import java.util.List;

public interface SalespersonService {
    public List<Salesperson> findAll();
    public Salesperson findById(Long id);
    public Salesperson save(Salesperson salesperson);
    public void deleteById(Long id);
    public Salesperson update(Salesperson salesperson);
    public List<Salesperson> findByNameContainingIgnoreCase(String name);
    public List<Salesperson> findByRegistrationNumberContainingIgnoreCase(String registrationNumber);
    public List<Salesperson> findByEstateAgentNameContainingIgnoreCase(String estateAgentName);
    public List<Salesperson> findByEstateAgentLicenseNumberContainingIgnoreCase(String estateAgentLicenseNumber);
    public List<Salesperson> findByRegistrationStartDateBetween(LocalDate startDate, LocalDate endDate);
    public List<Salesperson> findByRegistrationEndDateBetween(LocalDate startDate, LocalDate endDate);
}
