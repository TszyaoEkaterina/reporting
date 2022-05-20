package ru.netology;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

import java.util.Locale;

@UtilityClass
public class DataGenerator {
    private DataGenerator() {
    }
    
    public static ApplicantData generateData(String locale) {
        Faker faker = new Faker(new Locale(locale));
        ApplicantData applicant = new ApplicantData(faker.address().city(),
                faker.name().fullName(), faker.phoneNumber().phoneNumber());
        return applicant;
    }
}
