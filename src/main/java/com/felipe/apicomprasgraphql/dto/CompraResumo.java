package com.felipe.apicomprasgraphql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompraResumo {

    private Long compraId;
    private String cliente;
    private String produto;
    private int quantidade;

    public CompraResumo(Long compraId, String cliente, String produto, int quantidade) {
        this.compraId = compraId;
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
    }
}
