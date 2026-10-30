package net.bouderhem.anass.transactionservice.domain;
import lombok.*;


import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import jakarta.persistence.*;



@Entity
@Getter
@Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BankTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID accountId;
    private BigDecimal amount;
    private String currency;
    private String merchantCategory;
    private String country;
    private Instant createdAt;
}