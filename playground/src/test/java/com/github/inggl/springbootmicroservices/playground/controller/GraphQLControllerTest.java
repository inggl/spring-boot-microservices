package com.github.inggl.springbootmicroservices.playground.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest(GraphQLController.class)
class GraphQLControllerTest {
    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void dataById() {
        graphQlTester.documentName("dataDetails")
                .variable("id", 1)
                .execute()
                .path("dataById")
                .matchesJson("""
                        {
                            "id": "1",
                            "value": "1"
                        }
                        """);
    }
}