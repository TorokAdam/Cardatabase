package hu.cardatabase.service.domain;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class OwnerDto implements Serializable {

    private Long id;
    private String lastName;
    private String firstName;
    private String address;
    private String city;

    public OwnerDto(Long id, String lastName, String firstName, String address, String city) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.city = city;
    }

    public OwnerDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerDto ownerDto = (OwnerDto) o;
        return Objects.equals(id, ownerDto.id) && Objects.equals(lastName, ownerDto.lastName) && Objects.equals(firstName, ownerDto.firstName) && Objects.equals(address, ownerDto.address) && Objects.equals(city, ownerDto.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, address, city);
    }

    @Override
    public String toString() {
        return "OwnerDto{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
