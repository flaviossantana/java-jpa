package br.com.alura.model;

import br.com.alura.tipo.TipoMovimento;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoMovimento tipo;

    private BigDecimal valor;

    private LocalDateTime data;

    private String descricao;

    public Movimentacao() {
        super();
    }

    public Movimentacao(BigDecimal valor, TipoMovimento tipo, LocalDateTime data, String descricao) {
        this.valor = valor;
        this.tipo = tipo;
        this.data = data;
        this.descricao = descricao;
    }
}
