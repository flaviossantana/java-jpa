package br.com.alura.model;

import br.com.alura.tipo.TipoMovimento;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Movimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoMovimento tipo;

    @ManyToOne
    private Conta conta;

    @ManyToMany
    private List<Categoria> categorias;

    private BigDecimal valor;

    private LocalDateTime data;

    private String descricao;

    public Movimento() {
        super();
    }

    public Movimento(TipoMovimento tipo, Conta conta, List<Categoria> categorias, BigDecimal valor, LocalDateTime data, String descricao) {
        this.tipo = tipo;
        this.conta = conta;
        this.categorias = categorias;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
    }

    public Movimento(BigDecimal valor, TipoMovimento tipo, Conta conta, LocalDateTime data, String descricao) {
        this.tipo = tipo;
        this.conta = conta;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Movimento{" +
                "id=" + id +
                ", tipo=" + tipo +
                ", conta=" + conta +
                ", categorias=" + categorias +
                ", valor=" + valor +
                ", data=" + data +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
