
package com.ikmr.banbara23.yaeyama_liner_register.weather;

/**
 * TOPに表示する天気クラス
 */
public class Weather {
    String date;
    // 天気
    String weather;
    // 気温
    String temperature;
    // 風
    String wind;
    // 波
    String wave;

    public void setDate(String date) {
        this.date = date;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public void setWave(String wave) {
        this.wave = wave;
    }
}
