package pl.coderslab.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private LocalDate localdata;

    @OneToMany(mappedBy = "carts")
    private List<CartItem> cartItems = new ArrayList<>();

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLocaldata() {
        return localdata;
    }

    public void setLocaldata(LocalDate localdata) {
        this.localdata = localdata;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
