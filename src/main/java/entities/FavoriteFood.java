package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "favoriteFood")

public class FavoriteFood {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String combo;
    private String hotelName;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="name",nullable = false)
    private Hotel hotel;


    public FavoriteFood(Long id, String name, String combo, String hotelName,Hotel hotel) {
        this.id = id;
        this.name = name;
        this.combo = combo;
        this.hotelName = hotelName;
    }

    public FavoriteFood(){}

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

    public String getCombo() {
        return combo;
    }

    public void setCombo(String combo) {
        this.combo = combo;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }


    @Override
    public String toString() {
        return "FavoriteFood{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", combo='" + combo + '\'' +
                ", hotelName='" + hotelName + '\'' +
                '}';
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
