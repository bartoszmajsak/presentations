package org.arquillian.example.domain;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Beer implements Serializable {
    private static final long serialVersionUID = 5892013208071126314L;

    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Expose
    @Basic
    @NotNull
    private BigDecimal price;

    @Expose
    @Basic
    @NotNull
    private String name;

    @Expose
    @Basic
    @NotNull
    private BigDecimal alcohol;

    @Expose
    @Basic
    @NotNull
    private String code;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Expose
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Brewery brewery;

    protected Beer() {
        // to satisfy JPA
    }

    public Beer(String name, Brewery brewery, Type type, BigDecimal price, BigDecimal alcohol, String code) {
        this.name = name;
        this.price = price;
        this.alcohol = alcohol;
        this.type = type;
        this.code = code;
        this.brewery = brewery;
        this.brewery.addBeer(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Beer)) {
            return false;
        }

        Beer other = (Beer) obj;
        if (code == null) {
            if (other.code != null) {
                return false;
            }
        } else if (!code.equals(other.code)) {
            return false;
        }

        return true;
    }

    // --- Accessor methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(BigDecimal alcohol) {
        this.alcohol = alcohol;
    }

    public Brewery getBrewery() {
        return brewery;
    }

    public void setBrewery(Brewery brewery) {
        this.brewery = brewery;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}