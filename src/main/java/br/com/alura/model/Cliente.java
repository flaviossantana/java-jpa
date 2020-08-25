package br.com.alura.model;

import javax.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Conta conta;

    private String nome;

    private String profissão;

    private String endereco;

}
