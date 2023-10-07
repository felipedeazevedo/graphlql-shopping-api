package com.felipe.apicomprasgraphql.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompraInput {

    private Long id;
    private Integer quantidade;
    private String status;
    private Long clienteId;
    private Long produtoId;
}
