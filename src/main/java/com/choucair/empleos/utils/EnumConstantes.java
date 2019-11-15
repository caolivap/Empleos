package com.choucair.empleos.utils;

public enum EnumConstantes {
  TIPO_PALABRA_CLAVE("palabra clave"),
  TIPO_UBICACION("ubicación");

  private String valor;

  EnumConstantes(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
