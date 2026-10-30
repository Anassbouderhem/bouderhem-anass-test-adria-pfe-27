package net.bouderhem.anass.transactionservice.repositories;

import net.bouderhem.anass.transactionservice.domain.BankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BankTransactionRepository extends JpaRepository<BankTransaction, UUID> {
    List<BankTransaction> findByAccountId(UUID accountId);
}
