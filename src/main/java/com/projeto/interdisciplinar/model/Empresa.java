package com.projeto.interdisciplinar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Empresa")
@Getter
@Setter
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patrimonio_id")
    private Patrimonio patrimonio;

    @OneToOne
    private RH rh;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String cnpj;
    private String endereco;
    private Integer telefone;
    private String email;
    private String password;
    private String name;

}
