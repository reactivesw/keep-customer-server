package io.reactivesw.common.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.reactivesw.common.models.LocalizedString;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Davis on 16/11/21.
 */
public class LocalizedStringSerializer extends StdSerializer<LocalizedString> {
  public LocalizedStringSerializer() {
    this(null);
  }

  public LocalizedStringSerializer(Class<LocalizedString> t) {
    super(t);
  }

  @Override
  public void serialize(LocalizedString value, JsonGenerator gen, SerializerProvider provider) throws IOException {
    gen.writeStartObject();
    Map map = value.getLocalized();

    Iterator iterator = map.keySet().iterator();

    while (iterator.hasNext()) {
      String key = iterator.next().toString();
      String valueString = map.get(key).toString();
      gen.writeStringField(key, valueString);
    }

    gen.writeEndObject();
  }
}
