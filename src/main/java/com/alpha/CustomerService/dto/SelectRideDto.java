package com.alpha.CustomerService.dto;

public class SelectRideDto {

    private CoordinateDto sourceCoord;
    private CoordinateDto destCoord;

    public SelectRideDto() {
        super();
    }

    public SelectRideDto(CoordinateDto sourceCoord, CoordinateDto destCoord) {
        super();
        this.sourceCoord = sourceCoord;
        this.destCoord = destCoord;
    }

    public CoordinateDto getSourceCoord() {
        return sourceCoord;
    }

    public void setSourceCoord(CoordinateDto sourceCoord) {
        this.sourceCoord = sourceCoord;
    }

    public CoordinateDto getDestCoord() {
        return destCoord;
    }

    public void setDestCoord(CoordinateDto destCoord) {
        this.destCoord = destCoord;
    }
}