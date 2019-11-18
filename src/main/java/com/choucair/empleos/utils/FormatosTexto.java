package com.choucair.empleos.utils;

import java.text.Normalizer;
import java.text.Normalizer.Form;

public class FormatosTexto {

  public static String mayusculasSinAcento(String palabra) {
    return palabra =
        Normalizer.normalize(palabra, Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
  }
}
