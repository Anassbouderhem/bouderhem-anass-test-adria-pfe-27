package net.bouderhem.anass.transactionservice.domain;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;


@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
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