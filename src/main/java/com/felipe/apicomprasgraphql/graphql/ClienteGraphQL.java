package com.felipe.apicomprasgraphql.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.felipe.apicomprasgraphql.domain.Cliente;
import com.felipe.apicomprasgraphql.input.ClienteInput;
import com.felipe.apicomprasgraphql.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final ClienteService clienteService;

    public Cliente cliente(Long id) {
        return clienteService.findById(id);
    }

    public List<Cliente> clientes() {
        return clienteService.findAll();
    }

    public Cliente saveCliente(ClienteInput clienteInput) {
        ModelMapper mapper = new ModelMapper();
        return clienteService.save(mapper.map(clienteInput, Cliente.class));
    }

    public boolean deleteCliente(Long id) {
        return clienteService.deleteById(id);
    }
}
