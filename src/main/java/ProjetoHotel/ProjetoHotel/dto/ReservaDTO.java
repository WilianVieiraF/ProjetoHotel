package com.example.hotel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ReservaDTO {

    private Long id;

    @NotNull(message = "Data da reserva é obrigatória")
    private LocalDateTime dataReserva;

    @NotNull(message = "Data de check-in é obrigatória")
    private LocalDateTime dataCheckIn;

    @NotNull(message = "Data de check-out é obrigatória")
    private LocalDateTime dataCheckOut;

    @NotNull(message = "Hospede é obrigatório")
    private IdNomeDTO hospede;

    @NotNull(message = "Quarto é obrigatório")
    private IdNomeDTO quarto;

    public ReservaDTO() { }

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

    public IdNomeDTO getHospede() {
        return hospede;
    }

    public void setHospede(IdNomeDTO hospede) {
        this.hospede = hospede;
    }

    public IdNomeDTO getQuarto() {
        return quarto;
    }

    public void setQuarto(IdNomeDTO quarto) {
        this.quarto = quarto;
    }
}