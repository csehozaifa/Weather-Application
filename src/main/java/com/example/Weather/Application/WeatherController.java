package com.example.Weather.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;
    @GetMapping("/{city}")
    public ResponseEntity<WeatherModel> getWeather(@PathVariable String city) {
        try {
            WeatherModel weatherModel = weatherService.getWeatherByCity(city);
            return ResponseEntity.ok(weatherModel);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

}
