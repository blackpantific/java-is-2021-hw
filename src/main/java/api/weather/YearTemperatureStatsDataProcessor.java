package api.weather;

import java.util.Collection;

public interface YearTemperatureStatsDataProcessor {
    YearTemperatureStats parse(Collection<String> rawData);
}