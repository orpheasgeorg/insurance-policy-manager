package org.orpheus.insurancepolicymanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal amount;

    @NotNull
    private String description;

    @NotNull
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "policy_id", nullable = false)
    private Policy policy;
}
