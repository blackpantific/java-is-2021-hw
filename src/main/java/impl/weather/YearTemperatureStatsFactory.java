package impl.weather;

import api.weather.YearTemperatureStats;
import implemetations.YearTemperatureStatsImpl;

public class YearTemperatureStatsFactory {
    public static YearTemperatureStats create() {
        return new YearTemperatureStatsImpl();
    }
}