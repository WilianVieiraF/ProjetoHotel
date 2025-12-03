package com.example.hotel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "quartos")
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numero;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tipo_quarto_id", nullable = false)
    private TipoQuarto tipoQuarto;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusQuarto status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(TipoQuarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public StatusQuarto getStatus() {
        return status;
    }

    public void setStatus(StatusQuarto status) {
        this.status = status;
    }
}