package io.github.wilfred.springai;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

@Configuration
public class Configs {
    @Bean
    @Description("Get the weather in location") // function description
    public Function<WeatherService.Request, WeatherService.Response> getWeather() {
        return new WeatherService();
    }

}
