package br.com.alura.model;

import com.github.javafaker.Faker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;



    public Categoria() {
        super();
        this.nome = new Faker().beer().style();
    }

    public Categoria(Long id) {
        this.id = id;
    }

    public Categoria(String nome) {
        this.nome = nome;
    }
}
