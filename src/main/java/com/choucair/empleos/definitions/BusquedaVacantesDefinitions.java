package com.choucair.empleos.definitions;

import static com.choucair.empleos.utils.EnumConstantes.TIPO_PALABRA_CLAVE;
import static com.choucair.empleos.utils.EnumConstantes.TIPO_UBICACION;

import com.choucair.empleos.steps.AspiranteStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class BusquedaVacantesDefinitions {

  @Steps AspiranteStep aspiranteStep;

  @Dado("^que estoy en la sección de empleos de la página web de Choucair testing$")
  public void queEstoyEnLaSeccionDeEmpleosDeLaPaginaWebDeChoucairTesting() {
    aspiranteStep.AbrirHomePage();
    aspiranteStep.irASeccionEmpleos();
  }

  @Cuando("^busco vacantes con la palabra clave (.*)$")
  public void buscoVacantesConLaPalabraClave(String palabra) {
    aspiranteStep.buscarPalabraClave(palabra);
  }

  @Cuando("^busco vacantes en la ciudad (.*)$")
  public void buscoVacantesEnLaCiudad(String ciudad) {
    aspiranteStep.buscarVacanteUbicacion(ciudad);
  }

  @Entonces("^se muestran las vacantes disponibles que contienen la palabra (.*)$")
  public void seMuestranLasVacantesDisponiblesEnElMomento(String palabra) {
    aspiranteStep.verificarResultadosBusqueda(palabra, TIPO_PALABRA_CLAVE.getValor());
  }

  @Entonces("^se muestran las vacantes disponibles para la ciudad (.*)$")
  public void seMuestranLasVacantesDisponiblesEn(String ciudad) {
    aspiranteStep.verificarResultadosBusqueda(ciudad, TIPO_UBICACION.getValor());
  }
}
