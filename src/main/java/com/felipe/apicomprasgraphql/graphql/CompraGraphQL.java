package com.felipe.apicomprasgraphql.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.felipe.apicomprasgraphql.domain.Compra;
import com.felipe.apicomprasgraphql.dto.CompraResumo;
import com.felipe.apicomprasgraphql.input.CompraInput;
import com.felipe.apicomprasgraphql.service.ClienteService;
import com.felipe.apicomprasgraphql.service.CompraService;
import com.felipe.apicomprasgraphql.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CompraGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final CompraService compraService;
    private final ClienteService clienteService;
    private final ProdutoService produtoService;

    public Compra compra(Long id) {
        return compraService.findById(id);
    }

    public List<Compra> compras() {
        return compraService.findAll();
    }

    public List<CompraResumo> comprasRelatorio() {
        return compraService.findAllComprasRelatorio();
    }

    public Compra saveCompra(CompraInput compraInput) {
        ModelMapper mapper = new ModelMapper();
        Compra compra = mapper.map(compraInput, Compra.class);

        compra.setData(new Date());
        compra.setCliente(clienteService.findById(compraInput.getClienteId()));
        compra.setProduto(produtoService.findById(compraInput.getProdutoId()));

        return compraService.save(compra);
    }

    public boolean deleteCompra(Long id) {
        return compraService.deleteById(id);
    }
}
