package com.felipe.apicomprasgraphql.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.felipe.apicomprasgraphql.domain.Produto;
import com.felipe.apicomprasgraphql.graphql.input.ProdutoInput;
import com.felipe.apicomprasgraphql.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProdutoGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final ProdutoService produtoService;

    public Produto produto(Long id) {
        return produtoService.findById(id);
    }

    public List<Produto> produtos() {
        return produtoService.findAll();
    }

    public Produto saveProduto(ProdutoInput produtoInput) {
        ModelMapper mapper = new ModelMapper();
        return produtoService.save(mapper.map(produtoInput, Produto.class));
    }

    public boolean deleteProduto(Long id) {
        return produtoService.deleteById(id);
    }
}
