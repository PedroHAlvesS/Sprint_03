package br.com.compass.Sprint03.models.entity;

import javax.persistence.*;

@Entity
public class State {
    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String region;
    private int population;
    private String capital;
    private int area;

    public State() {
    }

    public State(String name, String region, int population, String capital, int area) {
        this.name = name;
        this.region = region;
        this.population = population;
        this.capital = capital;
        this.area = area;
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
}
