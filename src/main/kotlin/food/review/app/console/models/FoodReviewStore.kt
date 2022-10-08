package food.review.app.console.models

interface FoodReviewStore {
    fun findAll(): List<FoodReviewModel>
    fun findOne(id: Long): FoodReviewModel?
    fun create(foodReview: FoodReviewModel)
    fun update(foodReview: FoodReviewModel)
}