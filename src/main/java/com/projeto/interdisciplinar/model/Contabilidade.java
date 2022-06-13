package com.projeto.interdisciplinar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Contabilidade")
@Getter
@Setter
@AllArgsConstructor
public class Contabilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "entidade_id", foreignKey = @ForeignKey(name = "ENTIDADE_ID_FK"))
    private EntidadesGovernamentais entidadesGovernamentais;

    @OneToOne
    @JoinColumn(name = "balancete_id")
    private Balancetes balancetes;

    private String faturamento;

    private Date dataRegistro;

    private Date dataConsulta;

    private String validacao;

}
