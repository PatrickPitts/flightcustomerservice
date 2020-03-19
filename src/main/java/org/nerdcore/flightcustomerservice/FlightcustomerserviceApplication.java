package org.nerdcore.flightcustomerservice;

import org.nerdcore.flightcustomerservice.entities.UserPrincipal;
import org.nerdcore.flightcustomerservice.services.LoginServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaAuditing
@EnableTransactionManagement
@EnableJpaRepositories
@EntityScan("org.nerdcore.flightcustomerservice.entites")
public class FlightcustomerserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightcustomerserviceApplication.class, args);
    }

}
