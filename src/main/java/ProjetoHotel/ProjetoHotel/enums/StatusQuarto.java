package com.example.hotel.enums;

public enum StatusQuarto {

    DISPONIVEL(0),
    OCUPADO(1),
    MANUTENCAO(2);

    private final int codigo;

    StatusQuarto(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static StatusQuarto toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }

        for (StatusQuarto s : StatusQuarto.values()) {
            if (codigo.equals(s.getCodigo())) {
                return s;
            }
        }

        throw new IllegalArgumentException("Código inválido para StatusQuarto: " + codigo);
    }
}