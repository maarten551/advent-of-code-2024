package nl.bobbeldijk.day1.part2

import nl.bobbeldijk.util.Answerable
import nl.bobbeldijk.util.InputFile
import nl.bobbeldijk.util.InputReader
import java.util.stream.IntStream
import kotlin.math.abs

fun main() {
    Application().calculateAnswer(InputReader.readListFromInputFile(InputFile.DAY1))
}

class Application : Answerable<Int> {
    override fun calculateAnswer(input: MutableList<String>): Int {
        val extractPointsFromInput = fun(side: Int): List<Int> {
            return input.map { " +".toPattern().split(it)[side].toInt() }.sortedDescending()
        }

        val leftPoints = extractPointsFromInput(0)
        val rightPoints = extractPointsFromInput(1)
            .groupingBy { it }
            .eachCount()

        val answer = leftPoints
            .sumOf { rightPoints.getOrDefault(it, 0) * it }

        println("Answer: $answer")
        return answer;
    }

}