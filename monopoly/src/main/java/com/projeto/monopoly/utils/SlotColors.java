package com.projeto.monopoly.utils;

public enum SlotColors {

    MARROM,
    AZUL_BONDI,
    VERDE_MUSGO,
    ROSA,
    VERMELHO,
    AZUL_COBALTO,
    VERDE_JADE,
    ROXO;

    public String getValue(){
        return switch (this) {
            case MARROM -> "MARROM";
            case ROSA -> "ROSA";
            case AZUL_BONDI -> "AZUL_BONDI";
            case VERDE_MUSGO -> "VERDE_MUSGO";
            case VERMELHO -> "VERMELHO";
            case AZUL_COBALTO -> "AZUL_COBALTO";
            case VERDE_JADE -> "VERDE_JADE";
            case ROXO -> "ROXO";
            default -> null;
        };
    }
}
