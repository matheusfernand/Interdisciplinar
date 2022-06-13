package com.projeto.interdisciplinar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RH")
@Getter
@Setter
public class RH {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomeFuncionario;
    private String cpfFuncionario;
    private String telefoneFuncionario;
    private boolean status;
    private double salario;
    private Date dataAdmissao;
    private Date dataDemissao;

}
