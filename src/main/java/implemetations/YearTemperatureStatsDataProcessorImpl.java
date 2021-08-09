package implemetations;

import api.weather.DayTemperatureInfo;
import api.weather.YearTemperatureStats;
import api.weather.YearTemperatureStatsDataProcessor;

import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class YearTemperatureStatsDataProcessorImpl implements YearTemperatureStatsDataProcessor {

    private List<DayTemperatureInfo> dayTemperatureInfo;
    private int day;
    private Month month;
    private int temperature;

    @Override
    public YearTemperatureStats parse(Collection<String> rawData) {

        dayTemperatureInfo = new ArrayList<>();

        for (var item : rawData) {

            var temperatureData = item.split("[\\.\\s]");

            day = Integer.parseInt(temperatureData[0]);
            month = Month.values()[Integer.parseInt(temperatureData[1]) - 1];
            temperature = Integer.parseInt(temperatureData[2]);

            dayTemperatureInfo.add(new DayTemperatureInfoImpl(day, month, temperature));

        }

        var yearTemperatureStats = new YearTemperatureStatsImpl();
        yearTemperatureStats.setDayTemperatureInfos(dayTemperatureInfo);

        return yearTemperatureStats;
    }
}
