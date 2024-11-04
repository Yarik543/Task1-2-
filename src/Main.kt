//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main()
{
    println("Введите количество строк:")
    val rows = readLine()!!.toInt()//запрос ввода строк
    println("Введите количество столбцов:")
    val colums = readLine()!!.toInt()//запрос ввода столбцов

    val array = Array(rows) { Array(colums) { 0 } }//создание двумерного массива со значениями элементов = 0
    println("Введите ${rows * colums} трехзначных чисел:")//
    for (i in 0 until rows)
    {
        for (j in 0 until colums)
        {
            array[i][j] = readLine()!!.toInt()//заполнение элементов массива
        }
    }

    println("Двумерный массив:")//вывод двумерного массива
    for (i in 0 until rows) {
        println(array[i].joinToString(" "))
    }

    val uniqueDigits = array.flatten().joinToString("").toSet()
    println("Количество различных цифр: ${uniqueDigits.size}")
}