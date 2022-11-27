package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.domain.Cliente;
import com.udemy.compras.domain.ClienteService;
import com.udemy.compras.domain.Produto;
import com.udemy.compras.domain.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ProdutoService produtoService;

    public Produto produto(Long id){
        return produtoService.findById(id);
    }

    public List<Produto> produtos(){
        return produtoService.findAll();
    }

    public Produto saveProduto(ProdutoInput produtoInput){
        ModelMapper mapper = new ModelMapper();
        Produto produto = mapper.map(produtoInput, Produto.class);
        return produtoService.saveProduto(produto);
    }

    public Boolean deleteProduto(Long id){
        return produtoService.deleteById(id);
    }
}
