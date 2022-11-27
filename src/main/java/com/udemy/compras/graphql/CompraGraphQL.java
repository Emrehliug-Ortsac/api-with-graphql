package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.domain.ClienteService;
import com.udemy.compras.domain.Compra;
import com.udemy.compras.domain.CompraService;
import com.udemy.compras.domain.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompraGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private CompraService service;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    public Compra compra(Long id){
        return service.findById(id);
    }

    public List<Compra> getCompras(){
        return service.findAll();
    }

    public Compra saveCompra(CompraInput input){
        ModelMapper modelMapper = new ModelMapper();
        Compra compra = modelMapper.map(input, Compra.class);

        compra.setCliente(clienteService.findById(input.getClienteId()));
        compra.setProduto(produtoService.findById(input.getProdutoId()));

        return service.saveCompra(compra);
    }

    public Boolean deleteCompra(Long id){
        return service.deleteById(id);
    }

}
