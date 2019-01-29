package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.validator.groups.ValidationLoginGroup;
import pl.coderslab.validator.groups.ValidationRegisterGroup;

import javax.persistence.*;
import javax.validation.groups.Default;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(groups = {ValidationRegisterGroup.class})
    private String firstName;

    @NotEmpty(groups = {ValidationRegisterGroup.class})
    private String lastName;

    @NotEmpty(groups = {Default.class, ValidationLoginGroup.class, ValidationRegisterGroup.class})
    private String userName;

    @NotEmpty(groups = {Default.class, ValidationLoginGroup.class, ValidationRegisterGroup.class})
    private String password;

    @NotEmpty(groups = {ValidationRegisterGroup.class})
    private String city;

    @NotEmpty(groups = {ValidationRegisterGroup.class})
    private String street;

    @NotEmpty(groups = {ValidationRegisterGroup.class})
    private Long nr;

    @NotEmpty(groups = {ValidationRegisterGroup.class})
    private Long postCode;

    @NotEmpty(groups = {ValidationLoginGroup.class, ValidationRegisterGroup.class})
    private String email;

    private boolean enabled = true;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getNr() {
        return nr;
    }

    public void setNr(Long nr) {
        this.nr = nr;
    }

    public Long getPostCode() {
        return postCode;
    }

    public void setPostCode(Long postCode) {
        this.postCode = postCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{}";
    }
}
