package com.choucair.empleos.steps;

import com.choucair.empleos.pages.EmpleosPage;
import com.choucair.empleos.pages.HomePage;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class AspiranteStep {

  @Page HomePage homePage;
  @Page EmpleosPage empleosPage;

  @Step
  public void AbrirHomePage() {
    homePage.open();
  }

  public void irASeccionEmpleos() {
    homePage.irAEmpleos();
  }

  public void buscarPalabraClave(String palabra) {
    empleosPage.ingresarPalabraClave(palabra);
    empleosPage.clickearBuscarTrabajos();
  }

  public void buscarVacanteUbicacion(String ciudad) {
    empleosPage.ingresarCiudad(ciudad);
    empleosPage.clickearBuscarTrabajos();
  }

  public void verificarResultadosBusqueda(String palabra, String tipoBusqueda) {
    List<String> lstResultados = new ArrayList<>();
    if (tipoBusqueda == "palabra clave") {
      lstResultados = empleosPage.listarVacantes();
    } else if (tipoBusqueda == "ubicación") {
      lstResultados = empleosPage.listarUbicaciones();
    }
    MatcherAssert.assertThat(
        "No se mostraron vacantes para la búsqueda por " + tipoBusqueda + ":" + palabra,
        !lstResultados.isEmpty());
    for (String titulo : lstResultados) {
      //Collator auxTitulo = Collator.getInstance();
      //auxTitulo.setStrength(Collator.NO_DECOMPOSITION);
      titulo =
          Normalizer.normalize(titulo, Form.NFD)
              .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
      palabra =
          Normalizer.normalize(palabra, Form.NFD)
              .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
      MatcherAssert.assertThat(
          "El resultado " + titulo + " no contiene la " + tipoBusqueda + ":" + palabra,
          titulo.toUpperCase().contains(palabra.toUpperCase()));
    }
  }
}
