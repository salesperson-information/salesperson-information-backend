package olivertuesta.com.salesperson.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="salespersons")
public class Salesperson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    @NotEmpty
    private String name;

    @Column(name="registration_number")
    @NotEmpty
    private String registrationNumber;

    @Column(name="registration_start_date")
    @NotEmpty
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Registration start date must be in the format yyyy-MM-dd")
    private LocalDate registrationStartDate;

    @Column(name="registration_end_date")
    @NotEmpty
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Registration end date must be in the format yyyy-MM-dd")
    private LocalDate registrationEndDate;

    @Column(name="estate_agent_name")
    @NotEmpty
    private String estateAgentName;

    @Column(name="estate_agent_license_number")
    @NotEmpty
    private String estateAgentLicenseNumber;
}
