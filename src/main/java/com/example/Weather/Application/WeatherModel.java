package com.example.Weather.Application;

public class WeatherModel {
        private String cityName;
        private double temperature;
        private String description;
        private double windSpeed;

        public WeatherModel() {}

        public WeatherModel(String cityName, double temperature, String description, double windSpeed) {
            this.cityName = cityName;
            this.temperature = temperature;
            this.description = description;
            this.windSpeed = windSpeed;
        }

        // Getters and Setters
        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(double windSpeed) {
            this.windSpeed = windSpeed;
        }
    }


