package com.gabo.videoClub.entities;

public enum ClasificationPerAge {
    ATP("Apto para todo público", 0),
    SIETE_MAS("Recomendado para mayores de 7 años", 7),
    DOCE_MAS("Recomendado para mayores de 12 años", 12),
    DIECISEIS_MAS("Recomendado para mayores de 16 años", 16),
    DIECIOCHO_MAS("Recomendado para mayores de 18 años", 18);

    String description;
    Integer minimunAge;

    private ClasificationPerAge(String description, Integer minimunAge) {
        this.description = description;
        this.minimunAge = minimunAge;
    }
}
