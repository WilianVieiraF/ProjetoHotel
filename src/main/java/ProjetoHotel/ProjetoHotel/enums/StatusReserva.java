package com.example.hotel.enums;

public enum StatusReserva {
    PENDENTE(0),
    CONFIRMADA(1),
    CANCELADA(2),
    FINALIZADA(3);

    private final int codigo;

    StatusReserva(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static StatusReserva toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }

        for (StatusReserva status : StatusReserva.values()) {
            if (codigo.equals(status.getCodigo())) {
                return status;
            }
        }

        throw new IllegalArgumentException("Código inválido para StatusReserva: " + codigo);
    }
}