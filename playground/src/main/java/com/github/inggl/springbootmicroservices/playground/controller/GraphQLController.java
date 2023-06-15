package com.github.inggl.springbootmicroservices.playground.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

@Controller
public class GraphQLController {
    @QueryMapping
    public Data dataById(@Argument Long id) {
        return Data.getById(id);
    }

    public record Data(Long id, String value) {
        private static final List<Data> dataList = Arrays.asList(
                new Data(1L, "1"),
                new Data(2L, "2")
        );

        public static Data getById(Long id) {
            return dataList.stream().filter(data -> data.id.equals(id)).findFirst().orElse(null);
        }
    }
}
