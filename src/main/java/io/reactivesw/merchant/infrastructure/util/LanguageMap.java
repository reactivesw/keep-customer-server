package io.reactivesw.merchant.infrastructure.util;

import com.google.common.collect.Lists;

import io.reactivesw.merchant.application.model.Language;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Davis on 17/1/9.
 */
public class LanguageMap {
  private static final Language ZH = new Language("zh", "Chinese", "中文");

  private static final Language HI = new Language("hi", "Hindi", "हिन्दी, हिंदी");

  private static final Language ES = new Language("es", "Spanish", "español");

  private static final Language EN = new Language("en", "English", "English");

  private static final Language AR = new Language("ar", "Arabic", "العربية");

  private static final Language PT = new Language("pt", "Portuguese", "Português");

  private static final Language BN = new Language("bn", "Bengali", "বাংলা");

  private static final Language RU = new Language("ru", "Russian", "русский язык");

  private static final Language JA = new Language("ja", "Japanese", "日本語 (にほんご／にっぽんご)");

  private static final Language DE = new Language("de", "German", "Deutsch");

  private static final Language PA = new Language("pa", "Panjabi", "ਪੰਜਾਬੀ");

  private static final Language JV = new Language("jv", "Javanese", "basa Jawa");

  private static final Language KO = new Language("ko", "Korean", "한국어 (韓國語), 조선말 (朝鮮語)");

  private static final Language VI = new Language("vi", "Vietnamese", "Tiếng Việt");

  private static final Language TE = new Language("te", "Telugu", "తెలుగు");

  private static final Language MR = new Language("mr", "Marathi", "मराठी");

  private static final Language TA = new Language("ta", "Tamil", "தமிழ்");

  private static final Language FR = new Language("fr", "French", "français");

  private static final Language UR = new Language("ur", "Urdu", "اردو");

  private static final Language IT = new Language("it", "Italian", "Italiano");

  private static final Language TR = new Language("tr", "Turkish", "Türkçe");

  private static final Language FA = new Language("fa", "Persian", "فارسی");

  private static final Language GU = new Language("gu", "Gujarati", "ગુજરાતી");

  private static final Language PL = new Language("pl", "Polish", "polski");

  private static final Language UK = new Language("uk", "Ukrainian", "українська");

  private static final Language ML = new Language("ml", "Malayalam", "മലയാളം");

  private static final Language KN = new Language("kn", "Kannada", "ಕನ್ನಡ");

  private static final Language OR = new Language("or", "Oriya", "ଓଡ଼ିଆ");

  private static final Language MY = new Language("my", "Burmese", "ဗမာစာ");

  private static final Language TH = new Language("th", "Thai", "ไทย");

  private static final List<Language> LANGUAGE_MODELS;

  static {
    LANGUAGE_MODELS = Lists.newArrayList(
        ZH, HI, ES, EN, AR, PT, BN, RU, JA, DE,
        PA, JV, KO, VI, TE, MR, TA, FR, UR, IT,
        TR, FA, GU, PL, UK, ML, KN, OR, MY, TH
    );
  }

  /**
   * Is legal language.
   *
   * @param languageCode the language code
   * @return the boolean
   */
  public static boolean isLegalLanguage(String languageCode) {
    boolean result = false;

    Predicate<Language> predicate = l -> l.getLanguageCode().equals(languageCode);

    result = LANGUAGE_MODELS.parallelStream().anyMatch(predicate);

    return result;
  }

  /**
   * Gets language by code.
   *
   * @param languageCode the language code
   * @return the language by code
   */
  public static Language getLanguageByCode(String languageCode) {
    Language result = null;

    result = LANGUAGE_MODELS.parallelStream().filter(
        Language -> Language.getLanguageCode().equals(languageCode)
    ).findAny().orElse(null);

    return result;
  }

  /**
   * Gets all languages.
   *
   * @return the all languages
   */
  public static List<Language> getAllLanguages() {
    return Lists.newArrayList(LANGUAGE_MODELS);
  }
}
