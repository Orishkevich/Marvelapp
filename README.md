Сделать приложение для загрузки карт.
Прототип: https://marvelapp.com/22844ee

Реализовать последовательную загрузку карт 1 поток (с очередью).
API: загрузка карт HTTP REST (http://download.osmand.net/download.php?standard=yes&file=Denmark_europe_2.obf.zip)

Экраны:
1. Начальный экран, необходимые элементы:
- Список регионов мира
- Информации о доступном свободном месте на устройстве.
- Вложенная структура. Страны находятся в континентах, некоторые страны разбиты на регионы.

Информация закодирована в xml файле (https://github.com/osmandapp/OsmAnd-resources/blob/master/countries-info/regions.xml)
хранится в клиенте (использовать map=yes, map=no, чтобы определить есть карта для скачивания или нет, в строке 24 есть описание).
К имени файла нужно добавлять _2.obf.zip. Первую букву название карты надо делать заглавной, пример: denmark = Denmark.

Пример:
- Страны: Франция, Италия, Германия, Чехия, разбиты на регионы, по тапу на них, открывается новый экран со списком
регионов, пример Германия "Maps-3-1.png".
- Страны Дания, Беларусь не разбиты на регионы доступны для скачивания.

2. Экран регионов.
- После тапа на загрузку появляется индикатор загрузки у скачиваемого элемента.
- После тапа на загрузку под App bar'ом появляется индикатор загрузки, после тапа на него появляется диалог.
- После того как карта загрузилась, иконка слева окрашивается в зеленый цвет.


3. Диалог загрузки, необходимые элементы:
- Название скачиваемой страны
- Количество скачанных мегабайт и сколько осталось
- Индикатор загрузки
- Возможность отмены загрузки карты

Ресурсы:
Иконки находятся в архиве.

- Цвет App Bar #ff8800
- Цвет фона status bar #e68200
- Серый фон activity #eaeaea

Ячейка с названием региона/страны:
- Цвет фона ячейки #ffffff
- Высота 52dp
- Разделители 1dp, цвет #e5e5e5
- Иконка: ic_world_globe_dark.png или ic_map.png, цвет #727272
- Текст в ячейке: 16sp, цвет #212121.
