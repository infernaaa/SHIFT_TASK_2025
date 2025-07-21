# SHIFT_TASK_2025
Репа для задания ШИФТ 2025 гг.

Инструкция подразумевает, что вы пользуетесь Inteliji Idea

Инструкция к использованию:
1. клонировать ветку master
2. убедиться, что maven поднянул зависимости
3. в lifecycle maven выбрать clean
4. при успешном п.3 выбрать в lifecycle package
5. Не забудьте добавить файлы в каталог resources
6. далее вызвать терминал в проекте, а именно в каталоге target, проверить, что в каталоге имеется Magic_util-jar-with-dependencies.jar
7. флаги доступны согласно ТЗ, имеется поддержка POSIX
8. избегать любой кириллицы в путях для файлов
9. вы великолепны

Пример запуска команды "java -jar Magic_util-jar-with-dependencies.jar in2.txt" 
Пример запуска команды "java -jar Magic_util-jar-with-dependencies.jar -sfp test_  in2.txt"

p.s. В мавене есть все зависимости, но если что Java 23, picocli 4.7.5
