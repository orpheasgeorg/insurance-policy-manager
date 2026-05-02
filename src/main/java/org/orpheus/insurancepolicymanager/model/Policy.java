package org.orpheus.insurancepolicymanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Policy{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PolicyType policyType;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PolicyStatus policyStatus;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @NotNull
    private BigDecimal premium;

    @NotNull
    private LocalDate startDate;

    private LocalDate endDate;

}
