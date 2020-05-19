package com.project.template;

import com.project.template.util.IntegrationTestsContainer;
import org.flywaydb.core.Flyway;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RepositoryTest {

    @ClassRule
    public static PostgreSQLContainer container = IntegrationTestsContainer.getInstance();

    //@Autowired
    //protected SomeRepository someRepository;

    @BeforeClass
    public static void setUp() {
        Flyway flyway = Flyway.configure().dataSource(container.getJdbcUrl(), container.getUsername(), container.getPassword()).load();
        flyway.migrate();

        System.out.println(container.getLogs());
    }

    @Test
    public void persists_things_ok() {
        //someRepository.save(new Entity(arg1, arg2));
        //long count = someRepository.count();
        //assertThat(count).isEqualTo(1L);
    }

    //Any other integration tests...

}
