package net.bouderhem.anass.accountservice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.bouderhem.anass.accountservice.domain.AccountStatus;
import net.bouderhem.anass.accountservice.domain.BankAccount;
import net.bouderhem.anass.accountservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {

    private final BankAccountRepository accountRepository;

    public BankAccount createAccount(BankAccount account) {
        account.setStatus(AccountStatus.ACTIVE);
        return accountRepository.save(account);
    }

    public BankAccount getAccountById(UUID id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with ID: " + id));
    }

    public List<BankAccount> getAllAccounts() {
        return accountRepository.findAll();
    }

    public void updateBalance(UUID accountId, double amount) {
        BankAccount account = getAccountById(accountId);
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }
}
