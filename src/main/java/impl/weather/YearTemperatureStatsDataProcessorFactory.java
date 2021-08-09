package impl.weather;

import api.weather.YearTemperatureStatsDataProcessor;
import implemetations.YearTemperatureStatsDataProcessorImpl;

public class YearTemperatureStatsDataProcessorFactory {
    public static YearTemperatureStatsDataProcessor create() {
        return new YearTemperatureStatsDataProcessorImpl();
    }
}