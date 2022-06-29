package br.com.compass.Sprint03.models.form;

import br.com.compass.Sprint03.models.entity.State;

public class StateForm {
    private String name;
    private String region;
    private int population;
    private String capital;
    private int area;

    public State toState() {
        return new State(this.name, this.region, this.population, this.capital, this.area);
    }
}
