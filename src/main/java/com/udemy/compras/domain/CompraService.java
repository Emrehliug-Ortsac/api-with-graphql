package com.udemy.compras.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository repository;

    public List<Compra> findAll(){
        return repository.findAll();
    }

    public Compra findById(Long id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public Compra saveCompra(Compra compra){
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

}
