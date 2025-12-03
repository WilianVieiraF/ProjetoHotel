package com.example.hotel.dto;

import com.example.hotel.entity.ServicoConsumido;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ServicoConsumidoDTO {

    private Long id;

    @NotNull(message = "Data é obrigatória")
    private LocalDateTime data;

    @NotNull(message = "Hospede é obrigatório")
    private IdNomeDTO hospede;

    @NotNull(message = "Servico é obrigatório")
    private IdNomeDTO servico;

    public ServicoConsumidoDTO() { }

    public ServicoConsumidoDTO(ServicoConsumido entity) {
        this.id = entity.getId();
        this.data = entity.getData();
        this.hospede = new IdNomeDTO(entity.getHospede().getId(), entity.getHospede().getNome());
        this.servico = new IdNomeDTO(entity.getServico().getId(), entity.getServico().getDescricao());
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }

    public IdNomeDTO getHospede() { return hospede; }
    public void setHospede(IdNomeDTO hospede) { this.hospede = hospede; }

    public IdNomeDTO getServico() { return servico; }
    public void setServico(IdNomeDTO servico) { this.servico = servico; }
}