package br.com.compass.Sprint03.models.dto;

import br.com.compass.Sprint03.models.domain.Region;
import br.com.compass.Sprint03.models.entity.State;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class StateDto {
    private Long id;
    private String name;
    private String region;
    private int population;
    private String capital;
    private int area;

    public StateDto(State state) {
        this.id = state.getId();
        this.name = state.getName();
        this.region = state.getRegion();
        this.population = state.getPopulation();
        this.capital = state.getCapital();
        this.area = state.getArea();
    }

    public Long getId() {
        return id;
    }

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

    public static Page<StateDto> toStateDto(Page<State> states) {
        return states.map(StateDto::new);
    }
}
