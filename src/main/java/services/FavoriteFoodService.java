package services;

import entities.FavoriteFood;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;


public class FavoriteFoodService {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    List<FavoriteFood> favoriteFoodList;

    public FavoriteFoodService() {
        entityManagerFactory= Persistence.createEntityManagerFactory("foodunit");
        entityManager=entityManagerFactory.createEntityManager();
        favoriteFoodList=new ArrayList<>();
    }

    public void create(FavoriteFood favoriteFood){
entityManager.getTransaction().begin();
entityManager.persist(favoriteFood);
entityManager.getTransaction().commit();
    }

    public void createAll(List<FavoriteFood> favoriteFoodList){
        entityManager.getTransaction().begin();
        favoriteFoodList.stream().forEach(favoriteFood -> entityManager.persist(favoriteFood));
        entityManager.getTransaction().commit();

    }

    public List<FavoriteFood> readAll() {
        return entityManager.createQuery("SELECT f FROM FavoriteFood f", FavoriteFood.class).getResultList();
    }

    public FavoriteFood readId(Long id) {
       FavoriteFood favoriteFood= entityManager.find(FavoriteFood.class, id);
        return favoriteFood;
    }

    public void update(Long id, FavoriteFood newFavoriteFood) {
        entityManager.getTransaction().begin();
        FavoriteFood favoriteFood = entityManager.find(FavoriteFood.class, id);

        favoriteFood.setId(newFavoriteFood.getId());
        favoriteFood.setName(newFavoriteFood.getName());
        favoriteFood.setCombo(newFavoriteFood.getCombo());
        favoriteFood.setHotelName(newFavoriteFood.getHotelName());

        entityManager.getTransaction().commit();
    }
    public void delete(Long id) {
        FavoriteFood favoriteFood = entityManager.find(FavoriteFood.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(favoriteFood);
        entityManager.getTransaction().commit();
        System.out.printf("%s has been deleted", favoriteFood.toString());
    }

    public void delete(FavoriteFood favoriteFood) {
        entityManager.getTransaction().begin();
        entityManager.remove(favoriteFood);
        entityManager.getTransaction().commit();
        System.out.printf("%s has been deleted", favoriteFood.toString());
    }

}
