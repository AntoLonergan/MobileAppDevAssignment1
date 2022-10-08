package food.review.app.console.main

import mu.KotlinLogging
import java.awt.SystemColor.menu

private val logger = KotlinLogging.logger {}

var name = ""
var address = ""
var postCode = ""
var justEatRating = ""
var items = ""
var price = ""
var comments = ""
var myRating = ""
var recommend = ""

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
    println("Add Review")
    println()
    print("Enter Restaurant Name : ")
    name = readLine()!!
    print("Enter their address : ")
    address = readLine()!!
    print("Enter their PostCode : ")
    postCode = readLine()!!
    print("Enter their JustEat rating : ")
    justEatRating = readLine()!!
    print("Enter your items bought : ")
    items = readLine()!!
    print("Enter the price paid : ")
    price = readLine()!!
    print("Enter your Comments : ")
    comments = readLine()!!
    print("Enter your Rating. : ")
    myRating = readLine()!!
    print("Enter Yes or No to Recommend. : ")
    recommend = readLine()!!
    println("You entered [ $name ] for name " +
            "[ $address ] for address " +
            "[ $postCode ] for post code " +
            "[ $justEatRating ] for Just Eat Rating " +
            "[ $items ] for items " +
            "[ $price ] for price" +
            "[ $comments ] for comments" +
            "[ $myRating ] for your Rating" +
            "[ $recommend ] for would you recommend")
}

fun updateReview() {
    println("You Chose to Update Review")
    print("Enter a new name for Restaurant Name : ")
    name = readLine()!!
    print("Enter a new address for their address : ")
    address = readLine()!!
    print("Enter a new post code for their PostCode : ")
    postCode = readLine()!!
    print("Enter a new Just eat rating for their JustEat rating : ")
    justEatRating = readLine()!!
    print("Enter new items for your items bought : ")
    items = readLine()!!
    print("Enter new price for the price paid : ")
    price = readLine()!!
    print("Enter new comments for your Comments : ")
    comments = readLine()!!
    print("Enter new ratings for your Rating. : ")
    myRating = readLine()!!
    print("Enter a new answer to Yes or No to Recommend. : ")
    recommend = readLine()!!
    println("You entered [ $name ] for new name " +
            "[ $address ] for new address " +
            "[ $postCode ] for new post code " +
            "[ $justEatRating ] for new Just Eat Rating " +
            "[ $items ] for new items " +
            "[ $price ] for new price" +
            "[ $comments ] for new comments" +
            "[ $myRating ] for new your Rating" +
            "[ $recommend ] for new would you recommend")
}

fun listReview() {
    println("You Chose to List All Reviews")
}