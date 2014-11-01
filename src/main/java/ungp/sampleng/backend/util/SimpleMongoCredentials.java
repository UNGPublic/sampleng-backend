package ungp.sampleng.backend.util;

import org.springframework.data.authentication.UserCredentials;

public class SimpleMongoCredentials extends UserCredentials {

    public SimpleMongoCredentials(String username, String password) {
        super(username, password);
    }

    @Override
    public String getUsername() {
        return "sampleng";
    }

    @Override
    public String getPassword() {
        return "Softplan2015";
    }
}
