package net.bouderhem.anass.accountservice.repository;

import net.bouderhem.anass.accountservice.domain.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BankAccountRepository extends JpaRepository<BankAccount, UUID> {
}}
