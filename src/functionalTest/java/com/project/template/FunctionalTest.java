package com.project.template;

import com.project.template.util.FunctionalTestsContainer;
import org.flywaydb.core.Flyway;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TemplateApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FunctionalTest {

    @ClassRule
    public static PostgreSQLContainer container = FunctionalTestsContainer.getInstance();

    @Value("http://localhost:${local.server.port}")
    String baseUrl;

    @BeforeClass
    public static void setUp() {
        Flyway flyway = Flyway.configure().dataSource(container.getJdbcUrl(), container.getUsername(), container.getPassword()).load();
        flyway.migrate();

        System.out.println(container.getLogs());
    }

    //Insert functional tests below

}
