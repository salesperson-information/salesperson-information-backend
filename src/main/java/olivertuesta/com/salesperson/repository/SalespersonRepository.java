package olivertuesta.com.salesperson.repository;

import olivertuesta.com.salesperson.model.Salesperson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SalespersonRepository extends JpaRepository<Salesperson, Long> {
    List<Salesperson> findByNameContainingIgnoreCase(String name);
    List<Salesperson> findByRegistrationNumberContainingIgnoreCase(String registrationNumber);
    List<Salesperson> findByEstateAgentNameContainingIgnoreCase(String estateAgentName);
    List<Salesperson> findByEstateAgentLicenseNumberContainingIgnoreCase(String estateAgentLicenseNumber);
    List<Salesperson> findByRegistrationStartDateBetween(LocalDate startDate, LocalDate endDate);
    List<Salesperson> findByRegistrationEndDateBetween(LocalDate startDate, LocalDate endDate);
}
