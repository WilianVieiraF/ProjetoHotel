package ProjetoHotel.ProjetoHotel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class QuartoDTO {

    private Long id;

    @NotNull(message = "Número é obrigatório")
    private Integer numero;

    @NotNull(message = "Tipo de Quarto é obrigatório")
    private Long tipoQuartoId;

    @NotBlank(message = "Status é obrigatório")
    private String status;

    public QuartoDTO() { }

    public QuartoDTO(Long id, Integer numero, Long tipoQuartoId, String status) {
        this.id = id;
        this.numero = numero;
        this.tipoQuartoId = tipoQuartoId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Long getTipoQuartoId() {
        return tipoQuartoId;
    }

    public void setTipoQuartoId(Long tipoQuartoId) {
        this.tipoQuartoId = tipoQuartoId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}