package selectors;

import org.openqa.selenium.By;

import static helpers.CommonUtils.*;

public class intercarsSelectors {

  public static final By MAIN_SEARCH_QUERY = byXpath("//input[contains(@id,'main-search-query')]");
  public static final By COOKIE_CANCEL = byId("yl__btn--cancel");
  public static final By SEARCH_ICON = byCss(".icon.icon-search");
  public static final By ADVANCE_SEARCHING = byCss(".jqs-vehicle-chooser.add-on.vehicle.jqs-vehicle-tooltip");
  public static final By CAR_ICON = byCss(".icon.icon-car");
  public static final By CHOOSE_CAR = byXpath("//span[contains(text(),'Wybierz pojazd')]");
  public static final By SEARCH_BUTTON = byXpath("(//button[contains(text(),'Szukaj')])[1]");
  public static final By MAIN_RESULTS = byId("hits");
  public static final By FIRST_PRODUCT_DETAILS = byXpath("(//div[contains(@class,'prod-info-container')])[1]");
  public static final By FIRST_PRODUCT_PRICE = byXpath("(//span[contains(@class,'current-price nowrap')])[1]");
  public static final By ERROR_RESULTS = byCss(".h1.text-center.tvoffset1.voffset2");
  public static final By ADVANCE_MODAL = byId("jqs-vehicle-chain-selector");
  public static final By VEHICLE_BRAND_LIST = byXpath("//ul[contains(@id,'jqs-vehicle-brands-menu')]/li");
  public static final By OPEL_MODEL_LIST = byXpath("//table[contains(@class,'selectmenu-opts')]");
  public static final By TYPE_LIST = byXpath("//ul//tbody/tr[contains(@class,'selected-hide')]");
  public static final By VEHICLE_BRAND_BUTTON = byId("jqs-vehicle-brands-button");
  public static final By VEHICLE_BRAND_SELECT = byXpath("//a[contains(@id,'jqs-vehicle-brands-button')]//span[contains(@class,'ui-selectmenu-status')]");
  public static final By BRAND_OPEL = byXpath("//li/a[contains(text(),'Opel')]");
  public static final By VEHICLE_MODEL_BUTTON = byXpath("(//span[contains(@class,'ui-selectmenu-status') and contains(text(),'Wybierz...')])[2]");
  public static final By MODEL_VECTRA_KOMBI = byXpath("//td[contains(text(),'VECTRA C Kombi (Z02)')]");
  public static final By TYPE_19CDTI_Z19DTH = byXpath("//td[contains(text(),'1.9 CDTI (F35) (Z 19 DT)')]");
  public static final By MODAL_CHOOSE_BUTTON = byXpath("//button/span[contains(text(),'Wybierz')]");
  public static final By COOCKIE_BAR_X = byXpath("//div[contains(@class,'cookies-notify')]/a");
}
