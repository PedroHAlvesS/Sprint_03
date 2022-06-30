package br.com.compass.Sprint03.models.domain;

import org.apache.commons.lang3.text.WordUtils;

public enum Region {
    NORTE("Norte"), NORDESTE("Nordeste"),
    CENTRO_OESTE("Centro Oeste"), SUDESTE("Sudeste"), SUL("Sul");

    private String nameCapitalize;

    Region(String name) {
        this.nameCapitalize = name;
    }

    public String getNameCapitalize() {
        return nameCapitalize;
    }
}
