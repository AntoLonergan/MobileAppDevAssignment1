package food.review.app.console.views

import food.review.app.console.models.FoodReviewJSONStore
import food.review.app.console.models.FoodReviewModel

class FoodReviewView {
    fun menu(): Int {

        var option: Int
        var input: String? = null
        println()

        println("Main Menu")
        println(" 1. Add Restaurant Review")
        println(" 2. Update Restaurant Review")
        println(" 3. Delete Restaurant Review")
        println(" 4. List All Previously Reviewed Restauraunts")
        println(" 5. Search Reviews")
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
    fun listFoodReviews(foodReviews : FoodReviewJSONStore) {
        foodReviews.logAll()
        println("List All Food Reviews")
        println()
    }

    fun showFoodReviews(foodReview : FoodReviewModel) {
        if(foodReview != null)
            println("Food Review Details [ $foodReview ]")
        else
            println("FoodReview Not Found...")
    }

    fun addFoodReviewData(foodReview : FoodReviewModel) : Boolean {

        println()
        print("Enter Restaurant Name : eg (Carlo's)")
        foodReview.name = readLine()!!
        print("Enter their address : eg (Parnell Street Waterford)")
        foodReview.address = readLine()!!
        print("Enter their PostCode : eg (X42 DY45)")
        foodReview.postCode = readLine()!!
        print("Enter their JustEat rating : eg (8.75)")
        foodReview.justEatRating = readLine()!!.toDoubleOrNull() ?: 0.0
        print("Enter your items bought : eg (Burger, Chips, Chicken Wings.)")
        foodReview.items = readLine()!!
        print("Enter the price paid : eg (10.75)")
        foodReview.price = readLine()!!.toDoubleOrNull() ?: 0.0
        print("Enter your Comments : eg (Very Tasty, Good Value)")
        foodReview.comments = readLine()!!
        print("Enter your Rating as a Whole Number (0-10)   : eg (9) ")
        foodReview.myRating = readLine()!!.toIntOrNull() ?: 0

        return foodReview.name.isNotEmpty() &&
                foodReview.address.isNotEmpty() &&
                foodReview.address.isNotEmpty() &&
                foodReview.postCode.isNotEmpty() &&
                foodReview.items.isNotEmpty() &&
                foodReview.comments.isNotEmpty()
    }

    fun updateFoodReviewData(foodReview : FoodReviewModel) : Boolean {

        val tempName: String?
        val tempAddress: String?
        val tempPostCode: String?
        val tempJustEatRating: Double?
        val tempItems: String?
        val tempPrice: Double?
        val tempComments: String?
        val tempMyRating: Int?

        print("Enter a new name for Restaurant Name : eg(Carlo's)")
        tempName = readLine()!!
        print("Enter a new address for their address : eg(Parnell Street Waterford)")
        tempAddress = readLine()!!
        print("Enter a new post code for their PostCode : eg(X42 DY45) ")
        tempPostCode = readLine()!!
        print("Enter a new Just eat rating for their JustEat rating : eg(8.75) ")
        tempJustEatRating = readLine()!!.toDoubleOrNull() ?: 0.0
        print("Enter new items for your items bought : eg(Burger, Chips, Chicken Wings.)")
        tempItems = readLine()!!
        print("Enter new price for the price paid : eg(10.75)")
        tempPrice = readLine()!!.toDoubleOrNull()?: 0.0
        print("Enter new comments for your Comments : eg(Very Tasty, Good Value)")
        tempComments = readLine()!!
        print("Enter new ratings for your Rating. : eg(9)")
        tempMyRating = readLine()!!.toIntOrNull() ?: 0

        if (tempName.isNotEmpty() &&
            tempAddress.isNotEmpty() &&
            tempPostCode.isNotEmpty() &&
            tempItems.isNotEmpty() &&
            tempComments.isNotEmpty()
        ) {
            foodReview.name = tempName
            foodReview.address = tempAddress
            foodReview.postCode = tempPostCode
            foodReview.items = tempItems
            foodReview.comments = tempComments
            foodReview.price = tempPrice
            foodReview.justEatRating = tempJustEatRating
            foodReview.myRating = tempMyRating
            return true
        }
        return false
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
}
