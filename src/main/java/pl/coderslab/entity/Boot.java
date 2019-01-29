package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "boots")
public class Boot extends Product{

    @NotNull
    private Long size;

    @NotNull
    private Long flex;

    @NotEmpty
    private String color;

    @NotNull
    private String gender;

    public Boot() {
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getFlex() {
        return flex;
    }

    public void setFlex(Long flex) {
        this.flex = flex;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Boot{}";
    }
}
