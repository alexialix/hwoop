package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {


    @Test
    public void shouldSetDefaultStationCount() {
        Radio radio = new Radio();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldReturnDefaultStationCount() {
        Radio radio = new Radio();
        assertEquals(10, radio.getStationCount()); // Проверяем, что количество станций по умолчанию 10
    }

    // Проверка работы с кастомным количеством станций
    @Test
    public void shouldSetCustomStationCount() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(19);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation()); // После последней станции идет 0
    }

    // Проверка переключения на следующую станцию, если станций меньше 10
    @Test
    public void shouldSwitchToNextStationWithCustomCount() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(3);
        radio.nextStation();
        assertEquals(4, radio.getCurrentStation());
    }

    // Проверка переключения на предыдущую станцию, если станций меньше 10
    @Test
    public void shouldSwitchToPrevStationWithCustomCount() {
        Radio radio = new Radio(7);
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(6, radio.getCurrentStation()); // Проверяем, что последняя станция — 6
    }

    // Проверка установки громкости и её пределов
    @Test
    public void shouldNotIncreaseVolumeAboveMax() {
        Radio radio = new Radio();
        for (int i = 0; i < 101; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotDecreaseVolumeBelowMin() {
        Radio radio = new Radio();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    // Проверка правильного увеличения громкости
    @Test
    public void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    // Проверка правильного уменьшения громкости
    @Test
    public void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume(); // Увеличим до 1
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }
}
