package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "bindings")
public class Binding extends Product{

    @NotEmpty
    private String activites;

    @NotEmpty
    private String color;


//    @ManyToOne
//    private Cart cart;

    public Binding() {
    }


    public String getActivites() {
        return activites;
    }

    public void setActivites(String activites) {
        this.activites = activites;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

//    public Cart getCart() {
//        return cart;
//    }
//
//    public void setCart(Cart cart) {
//        this.cart = cart;
//    }

    @Override
    public String toString() {
        return "Binding{}";
    }


}
