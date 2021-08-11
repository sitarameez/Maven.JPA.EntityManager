package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class FavoriteFood {
    @Id
    private Long id;
    private String name;
    private String combo;
    private String shape;

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

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public FavoriteFood(Long id, String name, String combo, String shape) {
        this.id = id;
        this.name = name;
        this.combo = combo;
        this.shape = shape;
    }
}
