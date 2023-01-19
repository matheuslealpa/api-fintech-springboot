package com.example.app.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "CONTA")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONTA")
    @SequenceGenerator(name = "SEQ_CONTA", sequenceName = "CONTA_SEC")
    @Getter
    @Setter
    private Long id;

    @Column(name = "AGENCIA")
    @Getter
    @Setter
    private String agencia;

    @Column(unique = true, name = "NUM_CONTA")
    @Getter
    @Setter
    private String numConta;

    @Column(name = "INSTITUICAO")
    @Getter
    @Setter
    private String instituicao;

    @Column(name = "SALDO")
    @Getter
    private BigDecimal saldo;

}
