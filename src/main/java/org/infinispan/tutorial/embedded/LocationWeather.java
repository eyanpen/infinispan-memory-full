package org.infinispan.tutorial.embedded;

import org.infinispan.distribution.group.Grouper;
import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class LocationWeather {

   @ProtoField(number = 1, defaultValue = "0.0")
   final float temperature;

   @ProtoField(number = 2)
   final String conditions;

   @ProtoField(number = 3)
   final String country;

   @ProtoFactory
   public LocationWeather(float temperature, String conditions, String country) {
      this.temperature = temperature;
      this.conditions = conditions;
      this.country = country;
   }

   @Override
   public String toString() {
      return String.format("Country: %s,Temperature: %.1f° C, Conditions: %s", country,temperature, conditions);
   }

   public static class LocationGrouper implements Grouper<String> {

      @Override
      public String computeGroup(String key, String group) {
         return key.split(",")[1].trim();
      }

      @Override
      public Class<String> getKeyType() {
         return String.class;
      }
   }

}

