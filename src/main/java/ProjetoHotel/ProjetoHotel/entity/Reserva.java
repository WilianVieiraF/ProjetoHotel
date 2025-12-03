package com.example.hotel.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataReserva;

    @Column(nullable = false)
    private LocalDateTime dataCheckIn;

    @Column(nullable = false)
    private LocalDateTime dataCheckOut;

    @ManyToOne(optional = false)
    @JoinColumn(name = "hospede_id")
    private Hospede hospede;

    @ManyToOne(optional = false)
    @JoinColumn(name = "quarto_id")
    private Quarto quarto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDateTime dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalDateTime getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(LocalDateTime dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public LocalDateTime getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(LocalDateTime dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
}