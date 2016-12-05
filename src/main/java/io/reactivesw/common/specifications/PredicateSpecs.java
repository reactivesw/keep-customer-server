package io.reactivesw.common.specifications;

import io.reactivesw.common.entities.LocalizedStringEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by Davis on 16/12/5.
 */
public class PredicateSpecs {
  public static Predicate[] toPredicates(Root root, CriteriaBuilder cb, String
      whereCondition) {
    Predicate[] result = null;

    String[] whereConditions = whereCondition.split("and |or ");
    result = Arrays.stream(whereConditions)
        .map(s -> {
          return toPredicate(root, cb, s);
        }).toArray(Predicate[]::new);

    return result;
  }

  private static Predicate toPredicate(Root root, CriteriaBuilder cb, String
      whereCondition) {
    Predicate result = null;
    List conditions = splitCondition(insertOperator(whereCondition));

    if (conditions.size() == 3) {
      String name = conditions.get(0).toString();
      Path path = root.get(name);
      String operator = conditions.get(1).toString();
      String value = conditions.get(2).toString();
      switch (operator) {
        case "=":
          result = cb.equal(path, value);
          break;
        case ">=":
          //TODO string should convert to number or date
          result = cb.ge(path, Integer.valueOf(value));
          break;
        case "<=":
          //TODO string should convert to number or date
          result = cb.le(path, Integer.valueOf(value));
          break;
        case "<>":
          result = cb.notEqual(path, value);
          break;
        case ">":
          result = cb.greaterThan(path, value);
          break;
        case "<":
          result = cb.lessThan(path, value);
          break;
        default:
          break;
      }
    }
    if (conditions.size() == 4) {
      // TODO: 16/12/5 when conditions's size is 4, should join table
      //only for LocalizedStringEntity
      String joinTable = conditions.get(0).toString();
      String lang = conditions.get(1).toString();
//      String operator = conditions.get(2).toString();
      String text = conditions.get(3).toString();
      Join<Object, LocalizedStringEntity> join = root.join(joinTable);
      Path langPath = join.get("language");
      Path textPath = join.get("text");
      cb.equal(langPath, lang);
      result = cb.equal(textPath, text);
    }

    return result;
  }

  private static List splitCondition(String queryCondition) {
    String regEx = "\\(|\\||\\)|\"";
    Pattern p = Pattern.compile(regEx);

    String[] words = p.split(queryCondition);
    return Arrays.stream(words)
        .filter(s -> {
          return StringUtils.isNoneBlank(s);
        }).map(s -> {
          s = StringUtils.removeEnd(s, " ");
          s = StringUtils.removeStart(s, " ");
          return s;
        })
        .collect(Collectors.toList());

  }

  private static String insertOperator(String queryCondition) {
    String result = queryCondition;
    if (queryCondition.contains("<>")) {
      result = queryCondition.replaceAll("<>", "|<>|");
    } else if (queryCondition.contains(">=")) {
      result = queryCondition.replaceAll(">=", "|>=|");
    } else if (queryCondition.contains("<=")) {
      result = queryCondition.replaceAll("<=", "|<=|");
    } else if (queryCondition.contains(">")) {
      result = queryCondition.replaceAll(">", "|>|");
    } else if (queryCondition.contains("<")) {
      result = queryCondition.replaceAll("<", "|<|");
    } else if (queryCondition.contains("=")) {
      result = queryCondition.replaceAll("=", "|=|");
    }
    return result;
  }
}
