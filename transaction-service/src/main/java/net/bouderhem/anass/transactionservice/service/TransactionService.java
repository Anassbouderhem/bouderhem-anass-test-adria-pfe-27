package net.bouderhem.anass.transactionservice.service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.bouderhem.anass.transactionservice.feign.AccountRestClient;
import net.bouderhem.anass.transactionservice.model.AccountModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TransactionService {

    private BankTransactionRepository transactionRepository;
    private AccountRestClient accountRestClient;

    @Value("${bank.transaction.max-amount:1000}")
    private BigDecimal maxAmount;

    public BankTransaction saveTransaction(BankTransaction transaction) {
        if (transaction.getAmount().compareTo(BigDecimal.ZERO) <= 0 || transaction.getAmount().compareTo(maxAmount) > 0) {
            throw new RuntimeException("Invalid amount. Must be positive and <= " + maxAmount);
        }

        AccountModel account = accountRestClient.getAccountById(transaction.getAccountId());
        if (account == null || !"ACTIVE".equals(account.status())) {
            throw new RuntimeException("Account is either not found or BLOCKED");
        }

        if (!account.currency().equals(transaction.getCurrency())) {
            throw new RuntimeException("Currency mismatch");
        }

        transaction.setCreatedAt(Instant.now());
        BankTransaction savedTransaction = transactionRepository.save(transaction);
        return savedTransaction;
    }

    public List<BankTransaction> getTransactionsByAccountId(UUID accountId) {
        return transactionRepository.findByAccountId(accountId);
    }}
