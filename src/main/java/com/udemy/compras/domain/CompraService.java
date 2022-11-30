package com.udemy.compras.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository repository;

    public List<Compra> findAll(PageRequest pageRequest){
        return repository.findAll(pageRequest).getContent();
    }

    public Compra findById(Long id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public Compra saveCompra(Compra compra){
        if (compra.getQuantidade() > 100){
            throw new RuntimeException("Não é possível fazer uma compra com mais de 100 itens");
        }
        return repository.save(compra);
    }

    @Transactional
    public boolean deleteById(Long id){
        if (repository.findById(id).isPresent()){
            repository.deleteById(id);
            return true;
        }
        return false;
    }


    public List<Compra> findAllByCliente(Cliente cliente) {
        return repository.findAllByCliente(cliente);
    }
}
