package ru.netology;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@UtilityClass
public class DataGenerator {
    LocalDate currentDate = LocalDate.now();
    
    public static ApplicantData generateApplicantData(String locale) {
        Faker faker = new Faker(new Locale(locale));
        ApplicantData applicant = new ApplicantData(faker.address().city(),
                faker.name().fullName(), faker.phoneNumber().phoneNumber());
        return applicant;
    }
    
    public static String generateAppointmentDate1() {
        String appointmentDate1 = currentDate.plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return appointmentDate1;
    }
    
    public static String generateAppointmentDate2() {
        String appointmentDate2 = currentDate.plusDays(7).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return appointmentDate2;
    }
    
    @Value
    public static class ApplicantData {
        private String city;
        private String fullName;
        private String phone;
    }
}
