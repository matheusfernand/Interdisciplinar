package com.projeto.interdisciplinar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Usuario")
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String usernameLogin;
    private String passwordLogin;
    private String cpf;
    private String name;
    private String telefone;
    private String email;
    private boolean admin;

}
