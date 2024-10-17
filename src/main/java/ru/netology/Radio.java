package ru.netology;

public class Radio {
    private int currentStation; // номер текущей радиостанции
    private int currentVolume;  // уровень громкости звука

    // Получить текущую радиостанцию
    public int getCurrentStation() {
        return currentStation;
    }

    // Установить радиостанцию с проверкой допустимости
    public void setCurrentStation(int currentStation) {
        if (currentStation >= 0 && currentStation <= 9) {
            this.currentStation = currentStation;
        }
    }

    // Переключение на следующую радиостанцию
    public void nextStation() {
        if (currentStation == 9) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    // Переключение на предыдущую радиостанцию
    public void prevStation() {
        if (currentStation == 0) {
            currentStation = 9;
        } else {
            currentStation--;
        }
    }

    // Получить текущий уровень громкости
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
