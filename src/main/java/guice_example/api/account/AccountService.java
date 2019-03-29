package guice_example.api.account;

import com.google.inject.servlet.RequestScoped;

import java.util.List;

@RequestScoped
public class AccountService {

    public List<String> all() {
        return List.of("Accounts");
    }
}
