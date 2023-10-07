package com.felipe.apicomprasgraphql.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.felipe.apicomprasgraphql.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QueryGraphQL implements GraphQLQueryResolver {

    private final ClienteRepository clienteRepository;

    public String hello() {
        return "Hello GraphQL";
    }

    public int soma(int a, int b) {
        return a + b;
    }
}
