package olivertuesta.com.salesperson.service.impl;

import jakarta.persistence.EntityNotFoundException;
import olivertuesta.com.salesperson.dto.SalespersonDto;
import olivertuesta.com.salesperson.model.Salesperson;
import olivertuesta.com.salesperson.repository.SalespersonRepository;
import olivertuesta.com.salesperson.service.SalespersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalespersonServiceImpl implements SalespersonService {

    @Autowired
    private SalespersonRepository salespersonRepository;


    @Override
    public Page<Salesperson> findAll(Pageable pageable) {
        return salespersonRepository.findAll(pageable);
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
    public Salesperson update(Long salespersonId, SalespersonDto updatedSalespersonDto) {
        Salesperson existingSalesperson = salespersonRepository.findById(salespersonId)
                .orElseThrow(() -> new EntityNotFoundException("Salesperson with ID " + salespersonId + " not found"));

        Salesperson updatedSalesperson = SalespersonDto.toEntity(updatedSalespersonDto);

        existingSalesperson.setName(updatedSalesperson.getName());
        existingSalesperson.setRegistrationNumber(updatedSalesperson.getRegistrationNumber());
        existingSalesperson.setRegistrationStartDate(updatedSalesperson.getRegistrationStartDate());
        existingSalesperson.setRegistrationEndDate(updatedSalesperson.getRegistrationEndDate());
        existingSalesperson.setEstateAgentName(updatedSalesperson.getEstateAgentName());
        existingSalesperson.setEstateAgentLicenseNumber(updatedSalesperson.getEstateAgentLicenseNumber());

        return salespersonRepository.save(existingSalesperson);
    }

    @Override
    public List<SalespersonDto> findByNameContainingIgnoreCase(String name) {
        List<Salesperson> salespersons = salespersonRepository.findByNameContainingIgnoreCase(name);
        return salespersons.stream()
                .map(SalespersonDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<SalespersonDto> findByRegistrationNumberContainingIgnoreCase(String registrationNumber) {
        List<Salesperson> salespersons = salespersonRepository.findByRegistrationNumberContainingIgnoreCase(registrationNumber);
        return salespersons.stream()
                .map(SalespersonDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<SalespersonDto> findByEstateAgentNameContainingIgnoreCase(String estateAgentName) {
        List<Salesperson> salespersons = salespersonRepository.findByEstateAgentNameContainingIgnoreCase(estateAgentName);
        return salespersons.stream()
                .map(SalespersonDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<SalespersonDto> findByEstateAgentLicenseNumber(String estateAgentLicenseNumber) {
        List<Salesperson> salespersons = salespersonRepository.findByEstateAgentLicenseNumber(estateAgentLicenseNumber);
        return salespersons.stream()
                .map(SalespersonDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<SalespersonDto> findByRegistrationStartDateBetween(LocalDate startDate, LocalDate endDate) {
        List<Salesperson> salespersons = salespersonRepository.findByRegistrationStartDateBetween(startDate, endDate);
        return salespersons.stream()
                .map(SalespersonDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<SalespersonDto> findByRegistrationEndDateBetween(LocalDate startDate, LocalDate endDate) {
        List<Salesperson> salespersons = salespersonRepository.findByRegistrationEndDateBetween(startDate, endDate);
        return salespersons.stream()
                .map(SalespersonDto::fromEntity)
                .collect(Collectors.toList());
    }
}
