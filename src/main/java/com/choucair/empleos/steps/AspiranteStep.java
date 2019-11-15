package com.choucair.empleos.steps;

import com.choucair.empleos.pages.EmpleosPage;
import com.choucair.empleos.pages.HomePage;
import com.choucair.empleos.utils.EnumConstantes;
import com.choucair.empleos.utils.FormatearTexto;
import java.util.ArrayList;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class AspiranteStep {

  @Page HomePage homePage;
  @Page EmpleosPage empleosPage;

  @Step
  public void abrirHomePage() {
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

  public void verificarResultadosBusqueda(String palabra, EnumConstantes tipoBusqueda) {
    List<String> lstResultados = new ArrayList<>();
    switch (tipoBusqueda) {
      case TIPO_PALABRA_CLAVE:
        lstResultados = empleosPage.listarVacantes();
      case TIPO_UBICACION:
        lstResultados = empleosPage.listarUbicaciones();
    }
    MatcherAssert.assertThat(
        "No se mostraron vacantes para la búsqueda por " + tipoBusqueda + ":" + palabra,
        !lstResultados.isEmpty());
    for (String titulo : lstResultados) {
      titulo = FormatearTexto.mayusculasSinAcento(titulo);
      palabra = FormatearTexto.mayusculasSinAcento(palabra);
      MatcherAssert.assertThat(
          "El resultado " + titulo + " no contiene la " + tipoBusqueda + ":" + palabra,
          titulo.toUpperCase().contains(palabra.toUpperCase()));
    }
  }
}
