package Tasks;

import static helpers.CommonUtils.*;
import static selectors.intercarsSelectors.*;
import static strings.intercarsStrings.INTERCARS_URL;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Task3 {
  @Test
  public void advanceSearching() {
    //wejdź na stronę
    getDriver().get(INTERCARS_URL);
    //poczekaj i zamknij cookie
    waitForElementClickable(COOKIE_CANCEL);
    click(COOKIE_CANCEL);
    click(COOCKIE_BAR_X);
    //otwórz modal zaawansowanego wyszukiwania
    click(CHOOSE_CAR);
    waitUntilElementPresent(ADVANCE_MODAL);

    //pobierz i wypisz ilość marek pojazdów
    click(VEHICLE_BRAND_BUTTON);
    List<WebElement> vehicle_brands = getElements(VEHICLE_BRAND_LIST);
    System.out.println("Ilość marek: " + vehicle_brands.size());
    //wybierz Opel i ilość modeli
    waitForXSeconds(2);
    click(BRAND_OPEL);
    assertText("Opel", VEHICLE_BRAND_SELECT);
    click(VEHICLE_MODEL_BUTTON);
    List<WebElement> opel_models = getElements(OPEL_MODEL_LIST);
    System.out.println("Ilość modeli dla Opel: " + opel_models.size());
    //wybierz Vectra C Kombi (Z02) i wypisz ilość typów
    click(MODEL_VECTRA_KOMBI);
    click(VEHICLE_MODEL_BUTTON);
    List<WebElement> vectraCKombi_types = getElements(TYPE_LIST);
    System.out.println("Ilość typów dla Vectra C Kombi: " + vectraCKombi_types.size());
    //wybierz 1.9 CDTI (F35) (Z 19 DT)
    waitForXSeconds(2);
    click(TYPE_19CDTI_Z19DTH);
    waitForXSeconds(2);
    click(MODAL_CHOOSE_BUTTON);
    //wypisz ilość wyników wyszukiwania
    System.out.println("Wynik wyszukiwania:");
    System.out.println(getText(MAIN_RESULTS));
    //zamknij przeglądarkę
    getDriver().quit();
  }
}
