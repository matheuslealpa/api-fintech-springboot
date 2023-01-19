package com.example.app.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "CLIENTE")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENTE")
    @SequenceGenerator(name = "SEQ_CLIENTE", sequenceName = "CLIENTE_SEQ")
    private Long id;
    
    @Column(name = "FULL_NAME")
    private String fullName;
    
    @Column(unique = true, name = "CPF")
    private String cpf;

    @Column(unique = true, name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL ,orphanRemoval = true)
    private Conta conta;

}
