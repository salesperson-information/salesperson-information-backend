package olivertuesta.com.salesperson.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import olivertuesta.com.salesperson.model.Salesperson;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalespersonDto {
    private String name;
    private String registrationNumber;
    private LocalDate registrationStartDate;
    private LocalDate registrationEndDate;
    private String estateAgentName;
    private String estateAgentLicenseNumber;

    public static SalespersonDto fromEntity(Salesperson salesPerson) {
        return SalespersonDto.builder()
                .name(salesPerson.getName())
                .registrationNumber(salesPerson.getRegistrationNumber())
                .registrationStartDate(salesPerson.getRegistrationStartDate())
                .registrationEndDate(salesPerson.getRegistrationEndDate())
                .estateAgentName(salesPerson.getEstateAgentName())
                .estateAgentLicenseNumber(salesPerson.getEstateAgentLicenseNumber())
                .build();
    }

    public static Salesperson toEntity(SalespersonDto salesPersonDto) {
        return Salesperson.builder()
                .name(salesPersonDto.getName())
                .registrationNumber(salesPersonDto.getRegistrationNumber())
                .registrationStartDate(salesPersonDto.getRegistrationStartDate())
                .registrationEndDate(salesPersonDto.getRegistrationEndDate())
                .estateAgentName(salesPersonDto.getEstateAgentName())
                .estateAgentLicenseNumber(salesPersonDto.getEstateAgentLicenseNumber())
                .build();
    }
}
