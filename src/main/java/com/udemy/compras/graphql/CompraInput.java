package com.udemy.compras.graphql;

import com.udemy.compras.domain.Cliente;
import com.udemy.compras.domain.Produto;
import lombok.Data;

import java.util.Date;

@Data
public class CompraInput {

    private Long id;
    private int quantidade;
    private String status;
    private Date data;
    private Long clienteId;
    private Long produtoId;

}
