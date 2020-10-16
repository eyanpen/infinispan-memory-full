package org.infinispan.tutorial.embedded;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.infinispan.Cache;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class OpenWeatherMapService extends CachingWeatherService {
   final private static String OWM_BASE_URL = "http://api.openweathermap.org/data/2.5/weather";
   private DocumentBuilder db;
   private final String apiKey;

   public OpenWeatherMapService(String apiKey, Cache<String, LocationWeather> cache) {
      super(cache);
      this.apiKey = apiKey;
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      try {
         db = dbf.newDocumentBuilder();
      } catch (ParserConfigurationException e) {
      }
   }


   @Override
   protected LocationWeather fetchWeather(String location) {

      return new LocationWeather(
              new Random().nextInt(100),
            new Random().nextBoolean()?"Sunny":"Rain",
              location);
   }

}
