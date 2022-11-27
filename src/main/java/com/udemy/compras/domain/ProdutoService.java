package com.udemy.compras.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    public List<Produto> findAll(){
        return repository.findAll();
    }

    public Produto findById(Long id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public Produto saveProduto(Produto produto){
        return repository.save(produto);
    }

    @Transactional
    public Boolean deleteById(Long id){
        if (repository.findById(id).isPresent()){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

}
