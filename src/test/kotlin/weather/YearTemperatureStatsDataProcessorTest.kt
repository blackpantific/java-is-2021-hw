package weather

import impl.weather.YearTemperatureStatsDataProcessorFactory
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.io.File
import java.time.Month

internal class YearTemperatureStatsDataProcessorTest {
    private fun readRawDataFromFile(fileName: String = "data/temperature.txt") =
        File(fileName).readLines(Charsets.UTF_8).map { it.trim() }

    @Test
    fun `parse single string`() {
        val processor = YearTemperatureStatsDataProcessorFactory.create()
        val stats = processor.parse(
            listOf(
                "31.12 0"
            )
        )
        assertEquals(0, stats.getTemperature(31, Month.DECEMBER).temperature)
    }

    @Test
    fun `parse negative temp`() {
        val processor = YearTemperatureStatsDataProcessorFactory.create()
        val stats = processor.parse(
            listOf(
                "31.12 -12"
            )
        )
        assertEquals(-12, stats.getTemperature(31, Month.DECEMBER).temperature)
    }

    @Test
    fun `parse few lines`() {
        val processor = YearTemperatureStatsDataProcessorFactory.create()
        val stats = processor.parse(
            listOf(
                "31.12 -12",
                "16.12 5"
            )
        )
        assertEquals(5, stats.getTemperature(16, Month.DECEMBER).temperature)
        assertEquals(-12, stats.getTemperature(31, Month.DECEMBER).temperature)
    }

    @Test
    fun `avg temperature`() {
        val processor = YearTemperatureStatsDataProcessorFactory.create()
        val data = readRawDataFromFile()
        val stats = processor.parse(data)
        assertEquals(
            "Incorrect average temp after parsing raw data: $data",
            1.93,
            stats.getAverageTemperature(Month.NOVEMBER),
            0.01
        )
    }
}