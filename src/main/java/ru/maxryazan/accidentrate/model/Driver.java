package ru.maxryazan.accidentrate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


@Entity
@Getter
@NoArgsConstructor
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private  String firstName;

    private  String patronymic;

    private  String lastName;

    @Setter
    private int numbersOfCarCrashes;

    @Setter
    private int yearOfLastCrash;

    @Setter
    private int discount;

    @Setter
    private double accidentRate;

    public Driver(final String firstName, final String lastName, final String patronymic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.numbersOfCarCrashes = generateRandomNumber();
        this.yearOfLastCrash = generateRandomNumber();
        this.discount = calculateDiscount();
        this.accidentRate = calculateRate(numbersOfCarCrashes);
    }


    public double calculateRate(int numbersOfCarCrashes) {
        return 1 + 0.1 * numbersOfCarCrashes;
    }

    public int calculateYearsFromLastCarCrash(int yearOfLastCrash){
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        String yearDateNow = format.format(new Date());
        int yearNow = Integer.parseInt(yearDateNow);
        int yearsFromLastCarCrash = yearNow - yearOfLastCrash;
        if(yearsFromLastCarCrash > 5){
            yearsFromLastCarCrash = 5;
        }
    return yearsFromLastCarCrash;
    }

    public int calculateDiscount(){
        return calculateYearsFromLastCarCrash(yearOfLastCrash) * 10;
    }

    public int generateRandomNumber(){
        Random random = new Random();
        return random.nextInt(15);
    }
}
