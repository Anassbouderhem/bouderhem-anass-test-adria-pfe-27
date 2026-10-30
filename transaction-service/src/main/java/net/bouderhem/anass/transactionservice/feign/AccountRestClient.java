package net.bouderhem.anass.transactionservice.feign;

import net.bouderhem.anass.transactionservice.model.AccountModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.UUID;

@FeignClient(name = "ACCOUNT-SERVICE")
public interface AccountRestClient {

    @GetMapping("/api/accounts/{id}")
    @CircuitBreaker(name = "accountService", fallbackMethod = "getDefaultAccount")
    AccountModel getAccountById(@PathVariable UUID id);

    default AccountModel getDefaultAccount(UUID id, Exception exception) {
        return new AccountModel(id, "Not available", "BLOCKED", "N/A", 0.0);
    }
}