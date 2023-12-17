package olivertuesta.com.salesperson.controller;

import olivertuesta.com.salesperson.model.Salesperson;
import olivertuesta.com.salesperson.service.SalespersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/salesperson")
public class SalespersonController {

    @Autowired
    private SalespersonService salespersonService;

    @GetMapping("/")
    public String findAll() {
        return salespersonService.findAll().toString();
    }

    @GetMapping("/id/{id}")
    public String findById(@PathVariable Long id) {
        return salespersonService.findById(id).toString();
    }

    @GetMapping("/name/{name}")
    public String findByNameContainingIgnoreCase(@PathVariable String name) {
        return salespersonService.findByNameContainingIgnoreCase(name).toString();
    }

    @GetMapping("/registrationNumber/{registrationNumber}")
    public String findByRegistrationNumberContainingIgnoreCase(@PathVariable String registrationNumber) {
        return salespersonService.findByRegistrationNumberContainingIgnoreCase(registrationNumber).toString();
    }

    @GetMapping("/estateAgentName/{estateAgentName}")
    public String findByEstateAgentNameContainingIgnoreCase(@PathVariable String estateAgentName) {
        return salespersonService.findByEstateAgentNameContainingIgnoreCase(estateAgentName).toString();
    }

    @GetMapping("/estateAgentLicenseNumber/{estateAgentLicenseNumber}")
    public String findByEstateAgentLicenseNumberContainingIgnoreCase(@PathVariable String estateAgentLicenseNumber) {
        return salespersonService.findByEstateAgentLicenseNumberContainingIgnoreCase(estateAgentLicenseNumber).toString();
    }

    @GetMapping("/registrationStartDate/{startDate}/{endDate}")
    public String findByRegistrationStartDateBetween(@PathVariable LocalDate startDate, @PathVariable LocalDate endDate) {
        return salespersonService.findByRegistrationStartDateBetween(startDate, endDate).toString();
    }

    @GetMapping("/registrationEndDate/{startDate}/{endDate}")
    public String findByRegistrationEndDateBetween(@PathVariable LocalDate startDate, @PathVariable LocalDate endDate) {
        return salespersonService.findByRegistrationEndDateBetween(startDate, endDate).toString();
    }

    @PostMapping("/")
    public String save(@RequestBody Salesperson salesperson) {
        return salespersonService.save(salesperson).toString();
    }

    @PutMapping("/")
    public String update(@RequestBody Salesperson salesperson) {
        return salespersonService.update(salesperson).toString();
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        salespersonService.deleteById(id);
    }
}