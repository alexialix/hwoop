package ru.netology;

public class Radio {
    private int currentStation;
    private int stationCount;
    private int currentVolume;
    private static final int MAX_VOLUME = 100;
    private static final int MIN_VOLUME = 0;

    // Конструктор по умолчанию
    public Radio() {
        this.stationCount = 10; // По умолчанию 10 станций
    }

    // Конструктор с возможностью задания количества станций
    public Radio(int stationCount) {
        if (stationCount > 0) {
            this.stationCount = stationCount;
        } else {
            this.stationCount = 10; // Если введено некорректное количество, устанавливаем 10
        }
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation >= 0 && currentStation < stationCount) {
            this.currentStation = currentStation;
        }
    }

    // Метод переключения на следующую станцию
    public void nextStation() {
        if (stationCount == 1) {
            return; // Если всего 1 станция, то переключать не нужно
        }
        currentStation = (currentStation + 1) % stationCount;
    }

    // Метод переключения на предыдущую станцию
    public void prevStation() {
        if (stationCount == 1) {
            return; // Если всего 1 станция, то переключать не нужно
        }
        currentStation = (currentStation - 1 + stationCount) % stationCount;
    }

    public int getStationCount() {
        return stationCount;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setVolume(int volume) {
        if (volume >= MIN_VOLUME && volume <= MAX_VOLUME) {
            this.currentVolume = volume;
        }
    }

    public void increaseVolume() {
        if (currentVolume < MAX_VOLUME) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > MIN_VOLUME) {
            currentVolume--;
        }
    }
}
