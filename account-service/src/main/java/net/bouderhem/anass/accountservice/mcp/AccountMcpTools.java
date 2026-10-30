package net.bouderhem.anass.accountservice.mcp;

import lombok.RequiredArgsConstructor;
import net.bouderhem.anass.accountservice.domain.BankAccount;
import net.bouderhem.anass.accountservice.service.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.UUID;
import java.util.function.Function;

@Configuration
@RequiredArgsConstructor
public class AccountMcpTools {

    private final AccountService accountService;

    @Bean
    @Description("Consult a bank account by its UUID to retrieve balance and details")
    public Function<AccountRequest, BankAccount> getAccountTool() {
        return request -> accountService.getAccountById(UUID.fromString(request.accountId()));
    }

    public record AccountRequest(String accountId) {}
}