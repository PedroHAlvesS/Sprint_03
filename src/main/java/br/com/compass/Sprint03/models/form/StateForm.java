package br.com.compass.Sprint03.models.form;

import br.com.compass.Sprint03.models.domain.Region;
import br.com.compass.Sprint03.models.entity.State;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class StateForm {
    @NotBlank
    private String name;
    @NotBlank
    private String region;
    @PositiveOrZero
    private int population;
    @NotBlank
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
        String newRegion = standartRegion(this.region);
        return new State(this.name, newRegion, this.population, this.capital, this.area);
    }

    public State updateState(State state) {
        state.setName(this.name);
        state.setRegion(standartRegion(this.region));
        state.setPopulation(this.population);
        state.setCapital(this.capital);
        state.setArea(this.area);
        return state;
    }

    public static String standartRegion(String region) {
        return Region.valueOf(region.toUpperCase()).getNameCapitalize();
    }
}
