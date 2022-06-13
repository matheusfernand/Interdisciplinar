package com.projeto.interdisciplinar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Balancetes")
@Getter
@Setter
public class Balancetes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double saldoAtual;
    private double entrada;
    private double saida;
}
