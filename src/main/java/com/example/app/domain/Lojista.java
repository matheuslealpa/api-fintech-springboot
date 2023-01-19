package com.example.app.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "LOJISTA")
public class Lojista {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LOJISTA")
    @SequenceGenerator(name = "SEQ_LOJISTA", sequenceName = "LOJISTA_SEQ")
    private Long id;
    
    @Column(name = "FULL_NAME")
    private String fullName;
    
    @Column(unique = true, name = "CNPJ")
    private String cnpj;

    @Column(unique = true, name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @OneToOne(cascade = CascadeType.ALL ,orphanRemoval = true)
    private Conta conta;
    
}
