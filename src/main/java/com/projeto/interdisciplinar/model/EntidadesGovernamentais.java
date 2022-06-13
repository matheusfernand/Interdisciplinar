package com.projeto.interdisciplinar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "EntitadesGovernamentais")
@Getter
@Setter
public class EntidadesGovernamentais {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Integer numeroSolicitacao;
    private Integer numeroSolicitacaoPendentes;

}
