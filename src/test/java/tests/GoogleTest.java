package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.GooglePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTest extends BaseTest {

    @Test
    void openGoogle() {

        GooglePage googlePage = new GooglePage(driver);

        googlePage.open();

        assertEquals("Google", googlePage.getTitle());
    }

    @Test
    void openGoogleAgain() {

        GooglePage googlePage = new GooglePage(driver);

        googlePage.open();

        assertEquals("Google", googlePage.getTitle());
    }

    @Test
    void openGoogleThird() {

        GooglePage googlePage = new GooglePage(driver);

        googlePage.open();

        assertEquals("Google", googlePage.getTitle());
    }
}