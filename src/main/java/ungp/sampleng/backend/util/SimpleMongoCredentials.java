package ungp.sampleng.backend.util;

import org.springframework.data.authentication.UserCredentials;

public class SimpleMongoCredentials extends UserCredentials {

    public SimpleMongoCredentials() {
        super(null, null);
    }

    public SimpleMongoCredentials(String username, String password) {
        super(username, password);
    }

    @Override
    public String getUsername() {
        return super.getUsername() == null ? "sampleng" : super.getUsername();
    }

    @Override
    public String getPassword() {
        return super.getPassword() == null ? "Softplan2015" : super.getPassword();
    }
}
