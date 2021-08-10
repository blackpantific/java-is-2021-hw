package implemetations;

import api.weather.DayTemperatureInfo;
import api.weather.YearTemperatureStats;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class YearTemperatureStatsImpl implements YearTemperatureStats {

    private List<DayTemperatureInfo> dayTemperatureInfos;

    public YearTemperatureStatsImpl(){
        dayTemperatureInfos = new ArrayList<>();
    }

    @Override
    public void updateStats(DayTemperatureInfo info) {

        dayTemperatureInfos.add(
                new DayTemperatureInfoImpl(info.getDay(), info.getMonth(), info.getTemperature()));
    }

    @Override
    public Double getAverageTemperature(Month month) {

        var monthTempInfo = dayTemperatureInfos
                .stream()
                .filter(item -> item.getMonth() == month)
                .mapToDouble(DayTemperatureInfo::getTemperature)
                .average()
                .orElse(0.0);

        if(monthTempInfo!= 0.0){
            return monthTempInfo;
        }

        return null;
    }

    @Override
    public Map<Month, Integer> getMaxTemperature() {

        var dataMonth = new HashMap<Month, Integer>();

        for (var month : Month.values()) {

            var maxTemp =  dayTemperatureInfos
                    .stream()
                    .filter(item -> item.getMonth() == month)
                    .mapToInt(DayTemperatureInfo::getTemperature)
                    .max();

            if (maxTemp.isPresent()){
                dataMonth.put(month, maxTemp.getAsInt());
            }
        }

        return dataMonth;
    }

    @Override
    public List<DayTemperatureInfo> getSortedTemperature(Month month) {

//        var stream = dayTemperatureInfos.stream();
//        for (var item : dayTemperatureInfos) {
//
//            var res = stream
//                    .filter(day -> day.getTemperature() == item.getTemperature())
//                    .findFirst()
//                    .get();
//
//            var index =  dayTemperatureInfos.indexOf(res);
//            if (index != -1) {
//
//                var currentItem = item;
//                dayTemperatureInfos.set(dayTemperatureInfos.indexOf(item), res);
//                dayTemperatureInfos.set(index, currentItem);
//
//            }
//
//        }

        List<DayTemperatureInfo> monthDaysList1 = new ArrayList<>();

        List<DayTemperatureInfo> monthDaysList = dayTemperatureInfos
                .stream()
                .filter(item -> item.getMonth() == month)
                .sorted( (day1, day2) -> {

                    if(day1.getTemperature() < day2.getTemperature()){
                        return -1;
                    }
                    else if(day1.getTemperature() > day2.getTemperature()){
                        return 1;
                    }
                    else if(day1.getTemperature() == day2.getTemperature()){

                        var index1 = dayTemperatureInfos
                                .indexOf(day1);

                        var index2 = dayTemperatureInfos
                                .indexOf(day2);

                        if(index1 < index2){
                            return -1;
                        }
                        else{
                            return 1;
                        }
                    }
                    return 0;

                })
                .collect(Collectors.toList());

        return monthDaysList;
    }

    @Override
    public DayTemperatureInfo getTemperature(int day, Month month) {

        var dayTempInfo = dayTemperatureInfos
                .stream()
                .filter(item -> item.getDay() == day && item.getMonth() == month)
                .findFirst();
//some comment
        return (DayTemperatureInfo) dayTempInfo.orElse(null);
    }

    public void setDayTemperatureInfos(List<DayTemperatureInfo> dayTemperatureInfos) {
        this.dayTemperatureInfos = dayTemperatureInfos;
    }

    public Collection<DayTemperatureInfo> getDayTemperatureInfos(){
        return dayTemperatureInfos;
    }

}
