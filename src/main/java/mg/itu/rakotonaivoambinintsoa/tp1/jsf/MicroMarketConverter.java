/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.rakotonaivoambinintsoa.tp1.jsf;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import mg.itu.rakotonaivoambinintsoa.tp1.entities.MicroMarket;
import mg.itu.rakotonaivoambinintsoa.tp1.service.MicroMarketManager;

/**
 *
 * @author rakot
 */
@FacesConverter(value = "microMarketConverter", managed=true)
public class MicroMarketConverter implements Converter<MicroMarket> {
  @Inject
  private MicroMarketManager microMarketManager;

  /**
   * Convertit une String en microMarket.
   *
   * @param value valeur à convertir
   */
  @Override
  public MicroMarket getAsObject(FacesContext context, UIComponent component, String value) {
    if (value == null) return null;
    return microMarketManager.findById(value);
  }

  /**
   * Convertit un microMarket en String.
   *
   * @param value valeur à convertir
   */
  @Override
  public String getAsString(FacesContext context, UIComponent component, MicroMarket microMarket) {
    if (microMarket == null) return "";
    return microMarket.getZipCode();
  }
}