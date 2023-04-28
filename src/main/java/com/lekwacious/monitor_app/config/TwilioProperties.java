package com.lekwacious.monitor_app.config;

import com.twilio.Twilio;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Data
@Component
@Slf4j
public class TwilioProperties implements CommandLineRunner {
    @Value("${monitor.app.account_SID}")
    private String account_SID;
    @Value("${monitor.app.auth_SID}")
    private String auth_SID;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void run(String... strings) throws Exception {

        Twilio.init(account_SID,auth_SID );

        logger.info("Foo from @Value: {}", account_SID);
        logger.info("Foo from @Value: {}", auth_SID);

        logger.info("Foo from System.getenv(): {}", System.getenv("auth_SID")); // Same output as line above
    }

}
