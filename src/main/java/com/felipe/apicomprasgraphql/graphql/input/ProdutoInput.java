package com.felipe.apicomprasgraphql.graphql.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoInput {

    private Long id;
    private String nome;
    private double valor;
}
