package com.choucair.empleos.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.choucairtesting.com")
public class HomePage extends PageObject {

  @FindBy(xpath = "//ul[@id='menu-menu-1']//a[text()='Empleos']")
  private WebElement btnEmpleos;

  public void irAEmpleos() {
    btnEmpleos.click();
  }
}
