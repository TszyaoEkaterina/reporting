package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RepeatedAppointmentTest {
    
    @BeforeEach
    void openWebsite() {
        open("http://localhost:9999");
    }
    
    @Test
    void shouldReplanAppointmentAfterRepeatedAppointmentAndConfirmation() {
        DataGenerator.ApplicantData applicant = DataGenerator.generateApplicantData("ru");
        String appointmentDate1 = DataGenerator.generateAppointmentDate1();
        String appointmentDate2 = DataGenerator.generateAppointmentDate2();
        //first submission
        $("[placeholder=Город]").setValue(applicant.getCity());
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);//clear field
        $("[placeholder=\"Дата встречи\"]").setValue(appointmentDate1);
        $(byName("name")).setValue(applicant.getFullName());
        $(byName("phone")).setValue(applicant.getPhone());
        $(".checkbox").click();
        $(".grid-row button").click();
        $("[data-test-id=success-notification] .notification__title").should(ownText("Успешно!"));
        $("[data-test-id=success-notification] .notification__content").should(ownText("Встреча успешно " +
                "запланирована на \r\n" + appointmentDate1));
        //second submission
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);//clear field
        $("[placeholder=\"Дата встречи\"]").setValue(appointmentDate2);
        $(".grid-row button").click();
        $("[data-test-id=replan-notification] .notification__title").should(ownText("Необходимо подтверждение"));
        $("[data-test-id=replan-notification] .notification__content").should(ownText("У вас уже запланирована" +
                " встреча на другую дату. Перепланировать?"));
        //confirmation
        $("[data-test-id=replan-notification] .button").click();
        $("[data-test-id=success-notification] .notification__title").should(ownText("Успешно!"));
        $("[data-test-id=success-notification] .notification__content").should(ownText("Встреча успешно " +
                "запланирована на \r\n" + appointmentDate2));
    }
}
