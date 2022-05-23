package hu.cardatabase.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "Cars", schema = "dbo")
@NamedQuery(name = "CarsEntity.findAll", query = "select car from CarsEntity car")
public class CarsEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CarId")
    private Long id;
    @Column(name = "lp_number")
    private String lpNumber;
    @JoinColumn(name = "owner", referencedColumnName = "OwnerId")
    private OwnerEntity owner;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "color")
    private String color;

    public CarsEntity(Long id, String lpNumber, OwnerEntity owner, String make, String model, String color) {
        this.id = id;
        this.lpNumber = lpNumber;
        this.owner = owner;
        this.make = make;
        this.model = model;
        this.color = color;
    }

    public CarsEntity() {
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

    public OwnerEntity getOwner() {
        return owner;
    }

    public void setOwner(OwnerEntity owner) {
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
        CarsEntity that = (CarsEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(lpNumber, that.lpNumber) && Objects.equals(owner, that.owner) && Objects.equals(make, that.make) && Objects.equals(model, that.model) && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lpNumber, owner, make, model, color);
    }

    @Override
    public String toString() {
        return "CarsEntity{" +
                "id=" + id +
                ", lpNumber='" + lpNumber + '\'' +
                ", owner=" + owner +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
