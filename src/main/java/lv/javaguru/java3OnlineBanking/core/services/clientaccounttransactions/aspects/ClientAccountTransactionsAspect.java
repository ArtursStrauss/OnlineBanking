package lv.javaguru.java3OnlineBanking.core.services.clientaccounttransactions.aspects;

import lv.javaguru.java3OnlineBanking.core.domain.ClientAccountTransaction;
import lv.javaguru.java3OnlineBanking.core.services.clientaccounts.api.ClientAccountService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ClientAccountTransactionsAspect {

    @Autowired
    private ClientAccountService clientAccountService;

    @Around("execution(* lv.javaguru.java3OnlineBanking.core.services.clientaccounttransactions.impl.ClientAccountTransactionFactoryImpl.create(..))")
    public ClientAccountTransaction afterCreateClientAccountTransaction(ProceedingJoinPoint pjp) throws Throwable {

        ClientAccountTransaction clientAccountTransaction = (ClientAccountTransaction) pjp.proceed();

        clientAccountTransaction.getClientAccount().setBalance(clientAccountTransaction.getResultBalance());

        clientAccountService.update(clientAccountTransaction.getClientAccount());

        return clientAccountTransaction;
    }
}
