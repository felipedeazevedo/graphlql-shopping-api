package com.felipe.apicomprasgraphql.graphql.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteInput {

    private Long id;
    private String nome;
    private String email;
}
