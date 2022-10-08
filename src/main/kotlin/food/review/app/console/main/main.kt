package food.review.app.console.main

import mu.KotlinLogging
import java.awt.SystemColor.menu

private val logger = KotlinLogging.logger {}

fun main(args: Array<String>) {
    println("Food Review Kotlin App by Anthony Lonergan")
    logger.info { "Launching Food Review Console App" }

    var input: Int

    do {
        input = menu()
        when(input) {
            1 -> addReview()
            2 -> updateReview()
            3 -> listReview()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
    logger.info { "Shutting Down Food Review Console App" }
}

fun menu() : Int {

    var option : Int
    var input: String? = null

    println("Main Menu")
    println(" 1. Add Restaurant Review")
    println(" 2. Update Restaurant Review")
    println(" 3. List All Previously Reviewed Restauraunts")
    println("-1. Exit")
    println()
    print("Enter an integer : ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return option
}

fun addReview(){
    println("You Chose to add a Review")
}

fun updateReview() {
    println("You Chose to Update Review")
}

fun listReview() {
    println("You Chose to List All Reviews")
}