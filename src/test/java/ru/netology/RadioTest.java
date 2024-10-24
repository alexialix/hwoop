package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    // Тесты для станций
    @Test
    public void shouldSetDefaultStationCount() {
        Radio radio = new Radio();
        assertEquals(10, radio.getStationCount());
    }

    @Test
    public void shouldSetCustomStationCount() {
        Radio radio = new Radio(15);
        assertEquals(15, radio.getStationCount());
    }

    @Test
    public void shouldNotAllowInvalidStationCount() {
        Radio radio = new Radio(-5);
        assertEquals(10, radio.getStationCount()); // Проверяем, что при некорректном значении задается 10
    }

    @Test
    public void shouldSetCurrentStationWithinRange() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationOutOfRange() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation()); // Должно остаться на нуле

        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation()); // Должно остаться на нуле
    }

    @Test
    public void shouldWrapToFirstStationWhenNextStationAtMax() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(9);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldWrapToLastStationWhenPrevStationAtZero() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());
    }

    // Новый тест: проверка переключения на одну станцию
    @Test
    public void shouldNotSwitchStationIfOnlyOneStation() {
        Radio radio = new Radio(1);
        radio.setCurrentStation(0);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation()); // Текущая станция остается неизменной

        radio.prevStation();
        assertEquals(0, radio.getCurrentStation()); // Текущая станция остается неизменной
    }

    // Тесты для громкости
    @Test
    public void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseVolumeAboveMax() {
        Radio radio = new Radio();
        for (int i = 0; i < 101; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.setVolume(1);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotDecreaseVolumeBelowMin() {
        Radio radio = new Radio();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldSetVolumeWithinRange() {
        Radio radio = new Radio();
        radio.setVolume(50);
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetVolumeOutOfRange() {
        Radio radio = new Radio();
        radio.setVolume(-1);
        assertEquals(0, radio.getCurrentVolume()); // Громкость не должна устанавливаться ниже 0

        radio.setVolume(101);
        assertEquals(0, radio.getCurrentVolume()); // Громкость не должна устанавливаться выше 100
    }
}
