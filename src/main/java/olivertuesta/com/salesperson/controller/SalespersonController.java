package olivertuesta.com.salesperson.controller;

import olivertuesta.com.salesperson.dto.SalespersonDto;
import olivertuesta.com.salesperson.model.Salesperson;
import olivertuesta.com.salesperson.service.SalespersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/salesperson")
public class SalespersonController {

    private final SalespersonService salespersonService;

    public SalespersonController(SalespersonService salespersonService) {
        this.salespersonService = salespersonService;
    }

    @GetMapping("/")
    public ResponseEntity<Page<SalespersonDto>> findAll(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "10") int size) {
        Page<SalespersonDto> result = salespersonService.findAll(PageRequest.of(page, size))
                .map(SalespersonDto::fromEntity);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<SalespersonDto> findById(@PathVariable Long id) {
        SalespersonDto result = SalespersonDto.fromEntity(salespersonService.findById(id));
        return ResponseEntity.ok(result);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<SalespersonDto>> findByNameContainingIgnoreCase(@PathVariable String name) {
        List<SalespersonDto> result = salespersonService.findByNameContainingIgnoreCase(name);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/registrationNumber/{registrationNumber}")
    public ResponseEntity<List<SalespersonDto>> findByRegistrationNumberContainingIgnoreCase(@PathVariable String registrationNumber) {
        List<SalespersonDto> result = salespersonService.findByRegistrationNumberContainingIgnoreCase(registrationNumber);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/estateAgentName/{estateAgentName}")
    public ResponseEntity<List<SalespersonDto>> findByEstateAgentNameContainingIgnoreCase(@PathVariable String estateAgentName) {
        List<SalespersonDto> result = salespersonService.findByEstateAgentNameContainingIgnoreCase(estateAgentName);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/estateAgentLicenseNumber/{estateAgentLicenseNumber}")
    public ResponseEntity<List<SalespersonDto>> findByEstateAgentLicenseNumberContainingIgnoreCase(@PathVariable String estateAgentLicenseNumber) {
        List<SalespersonDto> result = salespersonService.findByEstateAgentLicenseNumber(estateAgentLicenseNumber);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/registrationStartDate/{startDate}/{endDate}")
    public ResponseEntity<List<SalespersonDto>> findByRegistrationStartDateBetween(@PathVariable LocalDate startDate, @PathVariable LocalDate endDate) {
        List<SalespersonDto> result = salespersonService.findByRegistrationStartDateBetween(startDate, endDate);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/registrationEndDate/{startDate}/{endDate}")
    public ResponseEntity<List<SalespersonDto>> findByRegistrationEndDateBetween(@PathVariable LocalDate startDate, @PathVariable LocalDate endDate) {
        List<SalespersonDto> result = salespersonService.findByRegistrationEndDateBetween(startDate, endDate);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/")
    public ResponseEntity<SalespersonDto> save(@RequestBody SalespersonDto salespersonDto) {
        Salesperson salesperson = SalespersonDto.toEntity(salespersonDto);
        SalespersonDto result = SalespersonDto.fromEntity(salespersonService.save(salesperson));
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<SalespersonDto> update(@PathVariable Long id, @RequestBody SalespersonDto salespersonDto) {
        Salesperson updatedSalesperson = salespersonService.update(id, salespersonDto);
        if (updatedSalesperson == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        SalespersonDto result = SalespersonDto.fromEntity(updatedSalesperson);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        salespersonService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}