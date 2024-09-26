package com.example.Weather.Application;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class WeatherService {

    private final String API_KEY = "YOUR_API_KEY"; // Replace with your OpenWeatherMap API key
    private final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather";

    public WeatherModel getWeatherByCity(String city) {
        RestTemplate restTemplate = new RestTemplate();

        String url = UriComponentsBuilder.fromHttpUrl(WEATHER_URL)
                .queryParam("q", city)
                .queryParam("appid", API_KEY)
                .queryParam("units", "metric")
                .toUriString();

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        // Extract the relevant fields from the API response
        Map<String, Object> main = (Map<String, Object>) response.get("main");
        Map<String, Object> wind = (Map<String, Object>) response.get("wind");
        String description = (String) ((Map<String, Object>) ((Map<String, Object>) response.get("weather")).get(0)).get("description");

        double temperature = (double) main.get("temp");
        double windSpeed = (double) wind.get("speed");

        return new WeatherModel(city, temperature, description, windSpeed);
    }
}

