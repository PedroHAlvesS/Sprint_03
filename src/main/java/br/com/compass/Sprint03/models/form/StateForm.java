package br.com.compass.Sprint03.models.form;

import br.com.compass.Sprint03.models.domain.Region;
import br.com.compass.Sprint03.models.entity.State;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class StateForm {
    @NotNull @NotEmpty
    private String name;
    @NotNull @NotEmpty
    private String region;
    @PositiveOrZero
    private int population;
    @NotNull @NotEmpty
    private String capital;

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public int getPopulation() {
        return population;
    }

    public String getCapital() {
        return capital;
    }

    public int getArea() {
        return area;
    }

    @PositiveOrZero
    private int area;

    public State toState() {
        String newRegion = Region.valueOf(this.region.toUpperCase()).getNameCapitalize();
        return new State(this.name, newRegion, this.population, this.capital, this.area);
    }
}
