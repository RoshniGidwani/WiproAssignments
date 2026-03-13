package slf4j;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

public class LoginTest {

    private static final Logger log =
            LoggerFactory.getLogger(LoginTest.class);

    public void login() {

        log.info("Login test started");
        log.warn("This is a warning message");
        log.error("Login failed due to invalid cred");
    }
}