package com.filo.springjms;

import org.apache.activemq.artemis.core.config.impl.ConfigurationImpl;
import org.apache.activemq.artemis.core.server.ActiveMQServer;
import org.apache.activemq.artemis.core.server.ActiveMQServers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJmsApplication {

    public static void main(String[] args) {
        ActiveMQServer server = null;
        try {
            server = ActiveMQServers.newActiveMQServer(new ConfigurationImpl()
                    .setPersistenceEnabled(false)
                    .setJournalDirectory("target/data/journal")
                    .setSecurityEnabled(false)
                    .addAcceptorConfiguration("invm", "vm://0"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            server.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        SpringApplication.run(SpringJmsApplication.class, args);
    }

}
