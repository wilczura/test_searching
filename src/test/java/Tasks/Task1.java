package Tasks;

import org.testng.annotations.Test;

import static helpers.CommonUtils.*;
import static selectors.intercarsSelectors.*;
import static strings.intercarsStrings.*;


public class Task1 {
  @Test
  public void visibityOfSearchTabElements() {
    //wejdź na stronę
    getDriver().get(INTERCARS_URL);
    //poczekaj i zamknij cookie
    waitForElementClickable(COOKIE_CANCEL);
    click(COOKIE_CANCEL);
    //sprawdź elementy
    checkIfIsDisplayed(MAIN_SEARCH_QUERY);
    checkIfIsDisplayed(SEARCH_ICON);
    checkIfIsDisplayed(ADVANCE_SEARCHING);
    checkIfIsDisplayed(CAR_ICON);
    assertText("Wybierz pojazd", CHOOSE_CAR);
    checkIfIsDisplayed(SEARCH_BUTTON);
    //zamknij przeglądarkę
    getDriver().quit();
  }
}

