package food.review.app.console.models

data class FoodReviewModel(
    var id: Long = 0,
    var name: String = "",
    var address: String = "",
    var postCode: String = "",
    var justEatRating: Double = 0.0,
    var items: String = "",
    var price: Double = 0.0,
    var comments: String = "",
    var myRating: Int = 0 )