package hu.cardatabase.service.domain;

import java.io.Serializable;
import java.util.Objects;

public class CarsDto implements Serializable {
    private Long id;
    private String lpNumber;
    private OwnerDto owner;
    private String make;
    private String model;
    private String color;

    public CarsDto(Long id, String lpNumber, OwnerDto owner, String make, String model, String color) {
        this.id = id;
        this.lpNumber = lpNumber;
        this.owner = owner;
        this.make = make;
        this.model = model;
        this.color = color;
    }

    public CarsDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLpNumber() {
        return lpNumber;
    }

    public void setLpNumber(String lpNumber) {
        this.lpNumber = lpNumber;
    }

    public OwnerDto getOwner() {
        return owner;
    }

    public void setOwner(OwnerDto owner) {
        this.owner = owner;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarsDto carsDto = (CarsDto) o;
        return Objects.equals(id, carsDto.id) && Objects.equals(lpNumber, carsDto.lpNumber) && Objects.equals(owner, carsDto.owner) && Objects.equals(make, carsDto.make) && Objects.equals(model, carsDto.model) && Objects.equals(color, carsDto.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lpNumber, owner, make, model, color);
    }

    @Override
    public String toString() {
        return "CarsDto{" +
                "id=" + id +
                ", lpNumber='" + lpNumber + '\'' +
                ", owner=" + owner +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
