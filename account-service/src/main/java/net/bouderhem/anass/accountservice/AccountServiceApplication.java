package net.bouderhem.anass.accountservice;

import net.bouderhem.anass.accountservice.domain.BankAccount;
import net.bouderhem.anass.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BankAccountRepository accountRepository) {
        return args -> {
            BankAccount account1 = BankAccount.builder()
                    .id(UUID.randomUUID())
                    .balance(50000.0)
                    .currency("MAD")
                    .build();

            BankAccount account2 = BankAccount.builder()
                    .id(UUID.randomUUID())
                    .balance(12000.0)
                    .currency("MAD")
                    .build();

            accountRepository.save(account1);
            accountRepository.save(account2);
        };
    }
}
