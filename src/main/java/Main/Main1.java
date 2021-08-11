package Main;

import entities.FavoriteFood;
import entities.Hotel;
import services.FavoriteFoodService;
import services.HotelService;

import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        FavoriteFoodService favoriteFoodService= new FavoriteFoodService();
        HotelService hotelService=new HotelService();
        List<Hotel> hotels=new ArrayList<>();
        List<FavoriteFood> favoriteFoodList= new ArrayList<>();
        Hotel abidha=new Hotel(1L,"Abidha","Nonveg","kottamedu");
        Hotel thalapakatti=new Hotel(2L,"Thalapakatti","Nonveg","Gandhipuram");
        Hotel aryaas=new Hotel(3L,"Aryaas","veg","sungam");
        hotels.add(abidha);
        hotels.add(thalapakatti);
        hotels.add(aryaas);

        FavoriteFood parotta=new FavoriteFood(1L,"Parotta","Salna","Abidha",abidha);
        FavoriteFood biryani=new FavoriteFood(2L,"Biryani","Pachadi","Thalapakatti",thalapakatti);
        FavoriteFood rumali=new FavoriteFood(3L,"Rumali","tikkaMasala","Aryaas",aryaas);
        favoriteFoodList.add(parotta);
        favoriteFoodList.add(biryani);
        favoriteFoodList.add(rumali);


        favoriteFoodService.createAll(favoriteFoodList);
        hotelService.createAll(hotels);
        FavoriteFood favoriteFood1=favoriteFoodService.readId(2L);
        Hotel hotel1=hotelService.readId(1L);
        System.out.println(favoriteFood1.toString());
        System.out.println(hotel1.toString());



    }
}
