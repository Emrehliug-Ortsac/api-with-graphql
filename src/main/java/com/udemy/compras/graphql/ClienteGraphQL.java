package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.domain.Cliente;
import com.udemy.compras.domain.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteService clienteService;

    public Cliente cliente(Long id){
        return clienteService.findById(id);
    }

    public List<Cliente> clientes(){
        return clienteService.findAll();
    }

    public Cliente saveCliente(ClienteInput clienteInput){
        ModelMapper mapper = new ModelMapper();
        Cliente cliente = mapper.map(clienteInput, Cliente.class);
        return clienteService.saveCliente(cliente);
    }

    public Boolean deleteCliente(Long id){
        return clienteService.deleteById(id);
    }

}
