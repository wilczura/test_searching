package Tasks;

import org.testng.annotations.Test;

import static helpers.CommonUtils.*;
import static org.apache.commons.lang.RandomStringUtils.randomAlphanumeric;
import static org.openqa.selenium.Keys.ENTER;
import static selectors.intercarsSelectors.*;
import static strings.intercarsStrings.INTERCARS_URL;

public class Task2 {
  @Test
  public void basicSearching(){
    //wejdź na stronę
    getDriver().get(INTERCARS_URL);
    //poczekaj i zamknij cookie
    waitForElementClickable(COOKIE_CANCEL);
    click(COOKIE_CANCEL);
    //1.Puste pole wyszukiwarki + ENTER
    click(MAIN_SEARCH_QUERY);
    getElement(MAIN_SEARCH_QUERY).sendKeys(ENTER);
    //Wynik wyszukiwania
    System.out.println("Wynik wyszukiwania:");
    System.out.println(getText(MAIN_RESULTS));
    System.out.println("========================================");

    //wstecz
    getDriver().navigate().back();

    //2. Wyszukaj słowo branżowe - "Akumulator" - wypisz ilość wszystkich wyników oraz pierwszy produkt
    type("Akumulator",MAIN_SEARCH_QUERY);
    click(SEARCH_BUTTON);
    System.out.println(getText(MAIN_RESULTS));
    System.out.println("Pierwszy produkt: " + getText(FIRST_PRODUCT_DETAILS));
    System.out.println("Cena: " + getText(FIRST_PRODUCT_PRICE));
    System.out.println("========================================");

    //wstecz
    getDriver().navigate().back();

    //3. Wyszukaj losowy ciąg znaków - wypisz wynik
    type(randomAlphanumeric(20),MAIN_SEARCH_QUERY);
    click(SEARCH_BUTTON);
    System.out.println(getText(ERROR_RESULTS));

    //zamknij przeglądarkę
    getDriver().quit();
  }
}
