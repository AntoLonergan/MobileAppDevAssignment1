package food.review.app.console.main

import food.review.app.console.models.FoodReviewModel
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

var foodReviews = ArrayList<FoodReviewModel>()

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
    var aFoodReview = FoodReviewModel()
    println("Add Review")
    println()
    print("Enter Restaurant Name : ")
    aFoodReview.name = readLine()!!
    print("Enter their address : ")
    aFoodReview.address = readLine()!!
    print("Enter their PostCode : ")
    aFoodReview.postCode = readLine()!!
    print("Enter their JustEat rating : ")
    aFoodReview.justEatRating = readLine()!!.toDouble()
    print("Enter your items bought : ")
    aFoodReview.items = readLine()!!
    print("Enter the price paid : ")
    aFoodReview.price = readLine()!!.toDouble()
    print("Enter your Comments : ")
    aFoodReview.comments = readLine()!!
    print("Enter your Rating. : ")
    aFoodReview.myRating = readLine()!!.toInt()
    println("You entered [ " + aFoodReview.name + " ] for name " +
            "[ " + aFoodReview.address + " ] for address " +
            "[ " + aFoodReview.postCode + " ] for post code " +
            "[ " + aFoodReview.justEatRating + " ] for Just Eat Rating " +
            "[ " + aFoodReview.items + " ] for items " +
            "[ " + aFoodReview.price + " ] for price" +
            "[ " + aFoodReview.comments + " ] for comments" +
            "[ " + aFoodReview.myRating + " ] for your Rating")

}

fun updateReview() {
    println("You Chose to Update Review")
    println()
    listReview()
    var searchId = getId()
    val aFoodReview = search(searchId)

    if (aFoodReview != null) {
        print("Enter a new name for Restaurant Name : ")
        aFoodReview.name = readLine()!!
        print("Enter a new address for their address : ")
        aFoodReview.address = readLine()!!
        print("Enter a new post code for their PostCode : ")
        aFoodReview.postCode = readLine()!!
        print("Enter a new Just eat rating for their JustEat rating : ")
        aFoodReview.justEatRating = readLine()!!.toDouble()
        print("Enter new items for your items bought : ")
        aFoodReview.items = readLine()!!
        print("Enter new price for the price paid : ")
        aFoodReview.price = readLine()!!.toDouble()
        print("Enter new comments for your Comments : ")
        aFoodReview.comments = readLine()!!
        print("Enter new ratings for your Rating. : ")
        aFoodReview.myRating = readLine()!!.toInt()
        println(
            "You entered [ " + aFoodReview.name + " ] for new name " +
                    "[ " + aFoodReview.address + " ] for new address " +
                    "[ " + aFoodReview.postCode + " ] for new post code " +
                    "[ " + aFoodReview.justEatRating + " ] for new Just Eat Rating " +
                    "[ " + aFoodReview.items + " ] for new items " +
                    "[ " + aFoodReview.price + " ] for new price" +
                    "[ " + aFoodReview.comments + " ] for new comments" +
                    "[ " + aFoodReview.myRating + " ] for new your Rating"
        )
    }
}

fun listReview() {
    println("List All Reviewed Restaurants")
    println()
    foodReviews.forEach { logger.info("${it}") }
}

fun searchFoodReview() {

    var searchId = getId()
    val aFoodReview = search(searchId)

    if(aFoodReview != null)
        println("Food Review Details [ $aFoodReview ]")
    else
        println("Food Review Not Found...")
}

fun getId() : Long {
    var strId : String? // String to hold user input
    var searchId : Long // Long to hold converted id
    print("Enter id to Search/Update : ")
    strId = readLine()!!
    searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
        strId.toLong()
    else
        -9
    return searchId
}

fun search(id: Long) : FoodReviewModel? {
    var foundFoodReviews: FoodReviewModel? = foodReviews.find { p -> p.id == id }
    return foundFoodReviews
}

fun dummyData() {
    foodReviews.add(FoodReviewModel(1, "New York New York", "So Good They Named It Twice"))
    foodReviews.add(FoodReviewModel(2, "Ring of Kerry", "Some place in the Kingdom"))
    foodReviews.add(FoodReviewModel(3, "Waterford City", "You get great Blaas Here!!"))
}