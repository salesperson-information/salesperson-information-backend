package olivertuesta.com.salesperson.service;

import olivertuesta.com.salesperson.dto.SalespersonDto;
import olivertuesta.com.salesperson.model.Salesperson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface SalespersonService {

    Page<Salesperson> findAll(Pageable pageable);

    Salesperson findById(Long id);
    Salesperson save(Salesperson salesperson);
    void deleteById(Long id);
    Salesperson update(Long salespersonId, SalespersonDto updatedSalespersonDto);
    List<SalespersonDto> findByNameContainingIgnoreCase(String name);
    List<SalespersonDto> findByRegistrationNumberContainingIgnoreCase(String registrationNumber);
    List<SalespersonDto> findByEstateAgentNameContainingIgnoreCase(String estateAgentName);
    List<SalespersonDto> findByEstateAgentLicenseNumber(String estateAgentLicenseNumber);
    List<SalespersonDto> findByRegistrationStartDateBetween(LocalDate startDate, LocalDate endDate);
    List<SalespersonDto> findByRegistrationEndDateBetween(LocalDate startDate, LocalDate endDate);
}
