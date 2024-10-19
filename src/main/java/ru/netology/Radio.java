package ru.netology;

public class Radio {
    private int currentStation; // номер текущей радиостанции
    private int currentVolume;  // уровень громкости звука
    private int stationCount;   // количество радиостанций

    // 10 станций по умолчанию
    public Radio() {
        this.stationCount = 10; // Количество станций по умолчанию
    }

    public int getStationCount() {
        return stationCount;
    }

    public Radio(int stationCount) {
        if (stationCount > 0) {
            this.stationCount = stationCount;
        } else {
            this.stationCount = 10;
        }
    }

    // Текущая радиостанция
    public int getCurrentStation() {
        return currentStation;
    }

    // Установить радиостанцию с проверкой допустимости
    public void setCurrentStation(int currentStation) {
        if (currentStation >= 0 && currentStation < stationCount) {
            this.currentStation = currentStation;
        }
    }

    // Переключение на следующую радиостанцию
    public void nextStation() {
        if (currentStation == stationCount - 1) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    // Переключение на предыдущую радиостанцию
    public void prevStation() {
        if (currentStation == 0) {
            currentStation = stationCount - 1;
        } else {
            currentStation--;
        }
    }

    // Текущий уровень громкости
    public int getCurrentVolume() {
        return currentVolume;
    }

    // Увеличение громкости на 1 с проверкой
    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    // Уменьшение громкости на 1 с проверкой
    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
}
