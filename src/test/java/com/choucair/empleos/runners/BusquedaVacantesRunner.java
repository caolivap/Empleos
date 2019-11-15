package com.choucair.empleos.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
  features = "src/test/resources/features/busqueda_vacantes.feature",
  snippets = SnippetType.CAMELCASE,
  glue = {"com.choucair.empleos.definitions"}
)
public class BusquedaVacantesRunner {}
