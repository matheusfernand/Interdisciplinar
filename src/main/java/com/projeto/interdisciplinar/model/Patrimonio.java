package com.projeto.interdisciplinar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Patrimonio")
@Getter
@Setter
public class Patrimonio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer codDoBem;
    private double valor;
    private String descricao;
    private Date dataRegistro;

}
