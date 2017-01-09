package io.reactivesw.project.infrastructure.util;

import com.google.common.collect.Lists;

import io.reactivesw.project.application.model.Currency;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Davis on 17/1/9.
 */
public final class CurrencyMap {

  private static Currency USD = new Currency("USD", "100", "US Dollar");

  private static Currency EUR = new Currency("EUR", "100", "Euro");

  private static Currency JPY = new Currency("JPY", "100", "Japanese Yen");

  private static Currency GBP = new Currency("GBP", "100", "British Pound");

  private static Currency AUD = new Currency("AUD", "100", "Australian Dollar");

  private static Currency CHF = new Currency("CHF", "100", "Swiss Franc");

  private static Currency CAD = new Currency("CAD", "100", "Canadian Dollar");

  private static Currency HKD = new Currency("HKD", "100", "Hong Kong Dollar");

  private static Currency SEK = new Currency("SEK", "100", "Swedish Krona");

  private static Currency NZD = new Currency("NZD", "100", "New Zealand Dollar");

  private static Currency ZAR = new Currency("ZAR", "100", "South African Rand");

  private static Currency RUB = new Currency("RUB", "100", "Russian Ruble");

  private static Currency INR = new Currency("INR", "100", "Indian Rupee");

  private static Currency SGD = new Currency("SGD", "100", "Singapore Dollar");

  private static Currency BGN = new Currency("BGN", "100", "Bulgarian Lev");

  private static Currency CNY = new Currency("CNY", "100", "Chinese yuan");

  private static Currency THB = new Currency("THB", "100", "Thai Baht");

  private static Currency HUF = new Currency("HUF", "100", "Hungarian Forint");

  private static Currency NOK = new Currency("NOK", "100", "Norwegian Krone");

  private static Currency MXN = new Currency("MXN", "100", "Mexican Peso");

  private static Currency DKK = new Currency("DKK", "100", "Danish Krone");

  private static Currency MYR = new Currency("MYR", "100", "Malaysian Ringgit");

  private static Currency PLN = new Currency("PLN", "100", "Polish Zloty");

  private static Currency BRL = new Currency("BRL", "100", "Brazilian Real");

  private static Currency PHP = new Currency("PHP", "100", "Philippine Peso");

  private static Currency IDR = new Currency("IDR", "100", "Indonesian Rupiah");

  private static Currency CZK = new Currency("CZK", "100", "Czech Koruna");

  private static Currency TWD = new Currency("TWD", "10", "Taiwan New Dollar");

  private static Currency KRW = new Currency("KRW", "100", "South Korean Won");

  private static Currency CLP = new Currency("CLP", "100", "Chilean Peso");

  private static List<Currency> Currencys;

  static {
    Currencys = Lists.newArrayList(
        USD, EUR, JPY, GBP, AUD, CHF, CAD, HKD, SEK, NZD,
        ZAR, RUB, INR, SGD, BGN, CNY, THB, HUF, NOK, MXN,
        DKK, MYR, PLN, BRL, PHP, IDR, CZK, TWD, KRW, CLP
    );
  }

  /**
   * Gets all currencies.
   *
   * @return the all currencies
   */
  public static List<Currency> getAllCurrencies() {
    return Lists.newArrayList(Currencys);
  }

  /**
   * Is legal currency.
   *
   * @param currencyCode the currency code
   * @return the boolean
   */
  public static boolean isLegalCurrency(String currencyCode) {
    boolean result = false;

    Predicate<Currency> predicate = c -> c.getCurrencyCode().equals(currencyCode);

    result = Currencys.parallelStream().anyMatch(predicate);

    return result;
  }

  /**
   * Gets currency by code.
   *
   * @param currencyCode the currency code
   * @return the currency by code
   */
  public static Currency getCurrencyByCode(String currencyCode) {
    Currency result = null;

    result = Currencys.parallelStream().filter(
        Currency -> Currency.getCurrencyCode().equals(currencyCode)
    ).findAny().orElse(null);

    return result;
  }
}
