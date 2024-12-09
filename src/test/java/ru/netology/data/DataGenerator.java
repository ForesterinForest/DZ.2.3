package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator (){

    }

    public static String generateDate(int shift){
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        String[] cities = new String[]{"Москва",
                "Санкт-Петербург",
                "Новосибирск",
                "Екатеринбург",
                "Казань",
                "Нижний Новгород",
                "Красноярск",
                "Челябинск", "Самара", "Уфа", "Ростов-на-Дону", "Краснодар", "Омск", "Воронеж", "Пермь"};
        return cities[new Random().nextInt(cities.length)];
    }
    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().lastName() +" " + faker.name().firstName();
    }
    public static String generatePhone(String locale){
        Faker faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();

    }
//public static String generatePhone(){
//    String[] number = new String[]{"+79000000000",
//            "+79000000001", "+79000000002", "+79000000003", "+79000000004",
//            "+79000000005","+79000000006", "+79000000007",
//            "+79000000008", "+79000000009", "89000000010", "+79000000011", "+79000000012",
//            "+79000000013", "+79000000014", "+79000000015", "+79000000016",
//            "+79000000017", "+79000000018", "+79000000019", "+79000000020",
//            "+79000000021", "+79000000022", "+79000000023",
//            "+79000000024", "+79000000025", "+79000000026", "+79000000027",
//            "+79000000028", "+79000000029", "+79000000030", "+79000000031",
//            "+79000000032", "+79000000033",
//            "+79000000034"};
//    return number[new Random().nextInt(number.length)];






    public static class Registration{
        private Registration(){

        }

        public static UserInfo generateUser(String locale){
            return new UserInfo(generateCity(),generateName(locale),generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo{
        String city;
        String name;
        String phone;
    }
}
