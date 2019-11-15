package com.choucair.empleos.pages;

import java.util.List;
import java.util.stream.Collectors;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmpleosPage extends PageObject {

  @FindBy(xpath = "//input[@id='search_keywords']")
  private WebElementFacade txtPalabraClave;

  @FindBy(xpath = "//input[@value='Buscar trabajos']")
  private WebElementFacade btnBuscarTrabajos;

  @FindBy(xpath = "//div[@class='position']//h3")
  private List<WebElement> lstVacantes;

  @FindBy(id = "search_location")
  private WebElementFacade txtUbicacion;

  @FindBy(xpath = "//div[@class='location']")
  private List<WebElement> lstUbicaciones;

  public void ingresarPalabraClave(String palabra) {
    txtPalabraClave.type(palabra);
  }

  public void clickearBuscarTrabajos() {
    btnBuscarTrabajos.click();
  }

  public List<String> listarVacantes() {
    return lstVacantes.stream().map(WebElement::getText).collect(Collectors.toList());
  }

  public void ingresarCiudad(String ciudad) {
    txtUbicacion.type(ciudad);
  }

  public List<String> listarUbicaciones() {
    return lstUbicaciones.stream().map(WebElement::getText).collect(Collectors.toList());
  }
}
