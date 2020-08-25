package br.com.alura.model;

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
    }

    public Conta(Integer agencia, Integer numero, String titular) {
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular.toUpperCase();
    }

    public Conta(Integer agencia, Integer numero, String titular, BigDecimal saldo) {
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
