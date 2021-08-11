package services;

import entities.Hotel;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;


public class HotelService{
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    List<Hotel> hotels;

    public HotelService() {
        entityManagerFactory= Persistence.createEntityManagerFactory("foodunit");
        entityManager=entityManagerFactory.createEntityManager();
        hotels=new ArrayList<>();
    }

    public void create(Hotel hotel){
        entityManager.getTransaction().begin();
        entityManager.persist(hotel);
        entityManager.getTransaction().commit();
    }

    public void createAll(List<Hotel> favoriteFoodList){
        entityManager.getTransaction().begin();
        favoriteFoodList.stream().forEach(favoriteFood -> entityManager.persist(favoriteFood));
        entityManager.getTransaction().commit();

    }

    public List<Hotel> readAll() {
        return entityManager.createQuery("SELECT h FROM Hotel h", Hotel.class).getResultList();
    }

    public Hotel readId(Long id) {
        Hotel hotel= entityManager.find(Hotel.class, id);
        return hotel;
    }

    public void update(Long id, Hotel newHotel) {
        entityManager.getTransaction().begin();
        Hotel hotel = entityManager.find(Hotel.class, id);

        hotel.setId(newHotel.getId());
        hotel.setName(newHotel.getName());
        hotel.setType(newHotel.getType());
        hotel.setLocation(newHotel.getLocation());

        entityManager.getTransaction().commit();
    }
    public void delete(Long id) {
        Hotel hotel = entityManager.find(Hotel.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(hotel);
        entityManager.getTransaction().commit();
        System.out.printf("%s has been deleted", hotel.toString());
    }

    public void delete(Hotel hotel) {
        entityManager.getTransaction().begin();
        entityManager.remove(hotel);
        entityManager.getTransaction().commit();
        System.out.printf("%s has been deleted", hotel.toString());
    }

}
