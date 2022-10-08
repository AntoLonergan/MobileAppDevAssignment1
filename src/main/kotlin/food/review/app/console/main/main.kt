package food.review.app.console.main

import food.review.app.console.models.FoodReviewModel
import mu.KotlinLogging
import java.awt.SystemColor.menu

private val logger = KotlinLogging.logger {}

var foodReview = ArrayList<FoodReviewModel>()

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
    foodReview.name = readLine()!!
    print("Enter their address : ")
    foodReview.address = readLine()!!
    print("Enter their PostCode : ")
    foodReview.postCode = readLine()!!
    print("Enter their JustEat rating : ")
    foodReview.justEatRating = readLine()!!.toDouble()
    print("Enter your items bought : ")
    foodReview.items = readLine()!!
    print("Enter the price paid : ")
    foodReview.price = readLine()!!.toDouble()
    print("Enter your Comments : ")
    foodReview.comments = readLine()!!
    print("Enter your Rating. : ")
    foodReview.myRating = readLine()!!.toInt()
    println("You entered [ " + foodReview.name + " ] for name " +
            "[ " + foodReview.address + " ] for address " +
            "[ " + foodReview.postCode + " ] for post code " +
            "[ " + foodReview.justEatRating + " ] for Just Eat Rating " +
            "[ " + foodReview.items + " ] for items " +
            "[ " + foodReview.price + " ] for price" +
            "[ " + foodReview.comments + " ] for comments" +
            "[ " + foodReview.myRating + " ] for your Rating")

}

fun updateReview() {
    println("You Chose to Update Review")
    print("Enter a new name for Restaurant Name : ")
    foodReview.name = readLine()!!
    print("Enter a new address for their address : ")
    foodReview.address = readLine()!!
    print("Enter a new post code for their PostCode : ")
    foodReview.postCode = readLine()!!
    print("Enter a new Just eat rating for their JustEat rating : ")
    foodReview.justEatRating = readLine()!!.toDouble()
    print("Enter new items for your items bought : ")
    foodReview.items = readLine()!!
    print("Enter new price for the price paid : ")
    foodReview.price = readLine()!!.toDouble()
    print("Enter new comments for your Comments : ")
    foodReview.comments = readLine()!!
    print("Enter new ratings for your Rating. : ")
    foodReview.myRating = readLine()!!.toInt()
    println("You entered [ " + foodReview.name + " ] for new name " +
            "[ " +foodReview.address + " ] for new address " +
            "[ " + foodReview.postCode + " ] for new post code " +
            "[ " + foodReview.justEatRating + " ] for new Just Eat Rating " +
            "[ " + foodReview.items + " ] for new items " +
            "[ " + foodReview.price + " ] for new price" +
            "[ " + foodReview.comments + " ] for new comments" +
            "[ " + foodReview.myRating + " ] for new your Rating")
}

fun listReview() {
    println("List All Reviewed Restaurants")
    println()
    foodReview.forEach { logger.info("${it}") }
}