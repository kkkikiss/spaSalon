package main.com.vsu.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class SpaSalon {

    private Long id;

    private String nameSalon;

    private BigDecimal Cost;

    private Long idProfile;

    public SpaSalon(Long id, String nameSalon, BigDecimal cost, Long idProfile) {
        this.id = id;
        this.nameSalon = nameSalon;
        Cost = cost;
        this.idProfile = idProfile;
    }

    public SpaSalon() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSalon() {
        return nameSalon;
    }

    public void setNameSalon(String nameSalon) {
        this.nameSalon = nameSalon;
    }

    public BigDecimal getCost() {
        return Cost;
    }

    public void setCost(BigDecimal cost) {
        Cost = cost;
    }

    public Long getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Long idProfile) {
        this.idProfile = idProfile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaSalon salon = (SpaSalon) o;
        return Objects.equals(id, salon.id) && Objects.equals(nameSalon, salon.nameSalon) && Objects.equals(Cost, salon.Cost) && Objects.equals(idProfile, salon.idProfile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameSalon, Cost, idProfile);
    }

    @Override
    public String toString() {
        return "Salon{" +
                "id=" + id +
                ", nameSalon='" + nameSalon + '\'' +
                ", Cost=" + Cost +
                ", idProfile=" + idProfile +
                '}';
    }
}
