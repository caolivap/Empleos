#language: es

Característica: Realizar búsqueda de vacantes por palabra clave
  Yo como aspirante a una vacante en Choucair Testing
  Quiero buscar vacantes por palabra clave
  Para conocer la disponibilidad de vacantes actualmente

  @EscenarioVacantesPalabraClave
  Esquema del escenario: Búsqueda de vacantes por palabra clave
    Dado que estoy en la sección de empleos de la página web de Choucair testing
    Cuando busco vacantes con la palabra clave <Palabra>
    Entonces se muestran las vacantes disponibles que contienen la palabra <Palabra>

    Ejemplos:
      | Palabra  |
      | analista |
      | Líder    |

  @EscenarioVacantesUbicacion
  Esquema del escenario: Búsqueda de vacantes por ubicación
    Dado que estoy en la sección de empleos de la página web de Choucair testing
    Cuando busco vacantes en la ciudad <Ciudad>
    Entonces se muestran las vacantes disponibles para la ciudad <Ciudad>

    Ejemplos:
      | Ciudad    |
      | Medellín  |
      | Bogotá    |
      | Pasto     |


