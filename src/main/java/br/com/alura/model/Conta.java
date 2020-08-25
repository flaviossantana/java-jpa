package br.com.alura.model;

import com.github.javafaker.Faker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Conta {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer agencia;

    private Integer numero;

    private String titular;

    private BigDecimal saldo;

    public Conta() {
        Faker titular = new Faker();
        this.titular = titular.starTrek().character();
        this.agencia = titular.number().numberBetween(1000, 9999);
        this.numero = titular.number().numberBetween(100000, 999999);
        this.saldo = BigDecimal.valueOf(titular.number().randomDouble(2, 1000, 99999));

    }

    public Conta(String titular) {
        this();
        this.titular = titular;
    }

    public Conta(Integer agencia, Integer numero, String titular) {
        this();
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;

    }

    public Conta(Integer agencia, Integer numero, String titular, BigDecimal saldo) {
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", agencia=" + agencia +
                ", numero=" + numero +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
