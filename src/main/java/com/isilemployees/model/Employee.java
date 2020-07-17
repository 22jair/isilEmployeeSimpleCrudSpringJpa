package com.isilemployees.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity
public class Employee {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String name;
    private String surnames;
    private String dni;
    private Integer cellphone;
    private Integer state;

    //joinColumns = @JoinColumn(name="idUser", referencedColumnName = "id"),
    //inverseJoinColumns = @JoinColumn(name="idRol", referencedColumnName = "id"))
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    /*
    @OneToMany
    @JoinColumn(name = "idUser")
    private Set<Reserve> reserves;
    */

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surnames='" + surnames + '\'' +
                ", dni='" + dni + '\'' +
                ", cellphone=" + cellphone +
                ", state=" + state +
                ", address=" + address +
                '}';
    }
}
