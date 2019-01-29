package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "skies")
public class Ski extends Product {

    @NotNull
    private Long length;

    @NotNull
    private Long radial;

    @NotEmpty
    private String gender;

    public Ski() {
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Long getRadial() {
        return radial;
    }

    public void setRadial(Long radial) {
        this.radial = radial;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Ski{}";
    }
}
