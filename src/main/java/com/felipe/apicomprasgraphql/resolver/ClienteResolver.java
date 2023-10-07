package com.felipe.apicomprasgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.felipe.apicomprasgraphql.domain.Cliente;
import com.felipe.apicomprasgraphql.domain.Compra;
import com.felipe.apicomprasgraphql.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClienteResolver implements GraphQLResolver<Cliente> {

    private final CompraService compraService;

    public List<Compra> compras(Cliente cliente) {
        return compraService.findAllByCliente(cliente);
    }
}
