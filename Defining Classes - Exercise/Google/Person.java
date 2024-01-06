package JavaAdvancedExercise.DefiningClasses.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private List<Pokemon> pokemonList;
    private List<Parents> parents;
    private List<Children> children;
    private Car car;

    public Person () {
        this.pokemonList = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();

    }
    public Person(Company company, List<Pokemon> pokemonList,
                  List<Parents> parents, List<Children> children, Car car) {
        this.company = company;
        this.pokemonList = pokemonList;
        this.parents = parents;
        this.children = children;
        this.car = car;
    }
    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Company:").append(System.lineSeparator());
        if (this.company != null) {
            sb.append(this.company).append(System.lineSeparator());
        }
        sb.append("Car:").append(System.lineSeparator());
        if (this.car != null) {
            sb.append(this.car).append(System.lineSeparator());
        }
        sb.append("Pokemon:").append(System.lineSeparator());
        if (this.pokemonList.size() > 0) {
            for (Pokemon pokemon : pokemonList) {
                sb.append(pokemon.toString()).append(System.lineSeparator());
            }
        }
        sb.append("Parents:").append(System.lineSeparator());
        if (this.parents.size() > 0) {
            for (Parents current : parents) {
                sb.append(current.toString()).append(System.lineSeparator());
            }
        }
        sb.append("Children:").append(System.lineSeparator());
        if (this.children.size() > 0) {
            for (Children currentChild : children) {
                sb.append(currentChild.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
