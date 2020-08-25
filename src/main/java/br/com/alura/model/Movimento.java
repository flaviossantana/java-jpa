package br.com.alura.model;

import br.com.alura.tipo.TipoMovimento;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Movimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoMovimento tipo;

    @ManyToOne
    private Conta conta;

    private BigDecimal valor;

    private LocalDateTime data;

    private String descricao;

    public Movimento() {
        super();
    }

    public Movimento(BigDecimal valor, TipoMovimento tipo, Conta conta, LocalDateTime data, String descricao) {
        this.valor = valor;
        this.tipo = tipo;
        this.conta = conta;
        this.data = data;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Movimento{" +
                "id=" + id +
                ", tipo=" + tipo +
                ", conta=" + conta +
                ", valor=" + valor +
                ", data=" + data +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
