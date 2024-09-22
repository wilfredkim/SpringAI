package io.github.wilfred.springai;


import java.util.function.Function;

public class WeatherService implements Function<WeatherService.Request, WeatherService.Response> {
    @Override
    public WeatherService.Response apply(WeatherService.Request request) {
        return new Response(20.6, Unit.C);
    }

    public enum Unit {C, F}

    public record Request(String location, Unit unit) {
    }

    public record Response(double temp, Unit unit) {
    }
}
