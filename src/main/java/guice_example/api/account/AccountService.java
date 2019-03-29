package guice_example.api.account;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;

import javax.persistence.EntityManager;
import java.util.List;

public class AccountService {
    @Inject
    EntityManager entityManager;

    public List<Account> all() {
        Account account = new Account();
        account.setName("John Doe");
        entityManager.getTransaction().begin();
        entityManager.persist(account);
        entityManager.flush();

        return entityManager.createNamedQuery("Account.all").getResultList();
    }
}