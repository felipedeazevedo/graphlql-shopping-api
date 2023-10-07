package com.felipe.apicomprasgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.felipe.apicomprasgraphql.domain.Cliente;
import com.felipe.apicomprasgraphql.domain.Compra;
import com.felipe.apicomprasgraphql.domain.Produto;
import com.felipe.apicomprasgraphql.service.ClienteService;
import com.felipe.apicomprasgraphql.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompraResolver implements GraphQLResolver<Compra> {

    private final ClienteService clienteService;
    private final ProdutoService produtoService;

    public String status(Compra compra) {
        return "Teste: " + compra.getStatus();
    }

    public Cliente cliente(Compra compra) {
        return clienteService.findById(compra.getCliente().getId());
    }

    public Produto produto(Compra compra) {
        return produtoService.findById(compra.getProduto().getId());
    }
}
