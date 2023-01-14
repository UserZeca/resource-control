package com.api.resourcecontrol.dtos;

import jakarta.validation.constraints.NotBlank;

public class FoodDto {

    @NotBlank
    private String foodName;
    @NotBlank
    private String placeOfOrigin;
    @NotBlank
    private String destination;
    @NotBlank
    private String responsibleForTransport;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getResponsibleForTransport() {
        return responsibleForTransport;
    }

    public void setResponsibleForTransport(String responsibleForTransport) {
        this.responsibleForTransport = responsibleForTransport;
    }
}
