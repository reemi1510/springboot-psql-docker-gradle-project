package com.project.template.util;

import org.testcontainers.containers.PostgreSQLContainer;

public class FunctionalTestsContainer extends PostgreSQLContainer<FunctionalTestsContainer> {

    private static final String IMAGE_VERSION = "postgres:9.6";
    private static FunctionalTestsContainer container;

    private FunctionalTestsContainer() {
        super(IMAGE_VERSION);
    }

    public static FunctionalTestsContainer getInstance() {
        if (container == null) {
            container = new FunctionalTestsContainer();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() {
        //JVM will handle container shut down.
    }
}
