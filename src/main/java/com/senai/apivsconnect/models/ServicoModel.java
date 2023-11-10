package com.senai.apivsconnect.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_servico")
public class ServicoModel implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String titulo;
    private String descrcao;
    private BigDecimal proposta;
    private String status_servico;

    @ManyToOne
    @JoinColumn(name = "id_dev", referencedColumnName = "id")
    private UsuarioModel dev;


}
