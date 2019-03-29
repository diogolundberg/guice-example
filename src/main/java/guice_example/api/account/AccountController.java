package guice_example.api.account;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("accounts")
public class AccountController {

    @Inject
    private AccountService accountService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getNext() {
        return accountService.all().toString();
    }
}
