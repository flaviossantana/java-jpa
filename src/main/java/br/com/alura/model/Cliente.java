package br.com.alura.model;

import com.github.javafaker.Faker;

import javax.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(unique = true)
    @OneToOne
    private Conta conta;

    private String nome;

    private String profissão;

    private String endereco;

    public Cliente() {
        super();
    }

    public Cliente(Conta conta) {
        this.conta = conta;
        Faker faker = new Faker();
        this.nome = faker.name().fullName();
        this.profissão = faker.commerce().department();
        this.endereco = faker.address().fullAddress();
    }

    public Cliente(Conta conta, String nome, String profissão, String endereco) {
        this.conta = conta;
        this.nome = nome;
        this.profissão = profissão;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", conta=" + conta +
                ", nome='" + nome + '\'' +
                ", profissão='" + profissão + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
