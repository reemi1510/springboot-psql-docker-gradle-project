package com.project.template.util;

import org.testcontainers.containers.PostgreSQLContainer;

public class IntegrationTestsContainer extends PostgreSQLContainer<IntegrationTestsContainer> {

    private static final String IMAGE_VERSION = "postgres:9.6";
    private static IntegrationTestsContainer container;

    private IntegrationTestsContainer() {
        super(IMAGE_VERSION);
    }

    public static IntegrationTestsContainer getInstance() {
        if (container == null) {
            container = new IntegrationTestsContainer();
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
