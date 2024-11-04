import java.util.*
fun main() {
    val scanner = Scanner(System.`in`)//С помощью `Scanner` получаем строку с введенными словами, разделенными пробелами.
    println("Введите слова, разделенные пробелами:")
    val inputWords = scanner.nextLine().split(" ")//Используем `split(" ")` для разделения строки на список слов.

    val groupedWords = groupWordsByLetters(inputWords)//Создаем пустой список `groupedWords` для хранения сгруппированных слов.

    println("Группы слов:")
    groupedWords.forEach { group ->
        // - Проходим по каждому списку слов в `groupedWords` и выводим его на экран с помощью `joinToString(", ")`.
        println(group.joinToString(", "))
    }
}

fun groupWordsByLetters(words: List<String>): List<List<String>> {
    val groupedWords = mutableListOf<List<String>>()

    // Создаем карту, где Ключ - это отсортированная строка букв слова (например, "aet" для слов "eat", "tea", "ate").
    //- Значение - это список слов, имеющих эти буквы (например, ["eat", "tea", "ate"]).
    //- Проходим по каждому слову в `words`:
    val wordMap = mutableMapOf<String, MutableList<String>>()
    words.forEach { word ->
        val sortedLetters = word.toCharArray().sortedArray().joinToString("")//  - Сортируем буквы в слове с помощью `toCharArray().sortedArray().joinToString("")`.
        wordMap.getOrPut(sortedLetters) { mutableListOf() }.add(word)//  - Используем `getOrPut` для добавления слова в список,
       // соответствующий отсортированной строке букв.
        // Если такого ключа еще нет в `wordMap`, создаем новый пустой список.
    }

    //  - Преобразуем `wordMap` в список списков слов, используя `values.forEach`.
    wordMap.values.forEach { groupedWords.add(it) }

    return groupedWords
}