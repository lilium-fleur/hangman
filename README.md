# Игра "Виселица"
Игра в слова с консольным интерфейсом, реализованная на Java.

[Правила игры.](https://ru.wikipedia.org/wiki/%D0%92%D0%B8%D1%81%D0%B5%D0%BB%D0%B8%D1%86%D0%B0_%28%D0%B8%D0%B3%D1%80%D0%B0%29)

Словарь находится в папке ``src/main/resources/words.txt``

----
Для запуска игры:
1. Установите Java JDK 21: ``https://www.oracle.com/java/technologies/downloads``
2. Установите Maven: ``https://maven.apache.org/download.cgi``
3. Склонируйте репозиторий:
```bash
git clone https://github.com/lilium-fleur/hangman.git
```
4. Перейдите в папку проекта:
```bash
cd hangman
```
5. Соберите проект:
```bash
mvn clean install
```
6. Запустите игру:
```bash
mvn exec:java
```
