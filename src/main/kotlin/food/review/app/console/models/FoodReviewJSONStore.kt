package food.review.app.console.models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import food.review.app.console.helpers.exists
import food.review.app.console.helpers.read
import food.review.app.console.helpers.write
import mu.KotlinLogging
import java.util.*

private val logger = KotlinLogging.logger {}

val JSON_FILE = "foodReviews.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<FoodReviewModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class FoodReviewJSONStore : FoodReviewStore {

    var foodReviews = mutableListOf<FoodReviewModel>()

    init {
        if (exists(JSON_FILE)) {
            deserialize()
        }
    }

    override fun findAll(): MutableList<FoodReviewModel> {
        return foodReviews
    }

    override fun findOne(id: Long) : FoodReviewModel? {
        var foundFoodReview: FoodReviewModel? = foodReviews.find { p -> p.id == id }
        return foundFoodReview
    }

    override fun create(foodReview: FoodReviewModel) {
        foodReview.id = generateRandomId()
        foodReviews.add(foodReview)
        serialize()
    }

    override fun update(foodReview: FoodReviewModel) {
        val foundFoodReview = findOne(foodReview.id)
        if (foundFoodReview != null) {
            foundFoodReview.name = foodReview.name
            foundFoodReview.address = foodReview.address
            foundFoodReview.postCode = foodReview.postCode
            foundFoodReview.justEatRating = foodReview.justEatRating
            foundFoodReview.items = foodReview.items
            foundFoodReview.price = foodReview.price
            foundFoodReview.comments = foodReview.comments
            foundFoodReview.myRating = foodReview.myRating
        }
        serialize()
    }

    override fun delete(foodReview: FoodReviewModel) {
        foodReviews.remove(foodReview)
        serialize()
    }


    internal fun logAll() {
        foodReviews.forEach { logger.info("${it}") }
    }

    private fun serialize() {
        val jsonString = gsonBuilder.toJson(foodReviews, listType)
        write(JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(JSON_FILE)
        foodReviews = Gson().fromJson(jsonString, listType)
    }

    internal fun restaurants(){
        val restaurants = mutableListOf<FoodReviewModel>()
        foodReviews.forEach {
            restaurants.add(it)
        }
        restaurants.sortWith(compareBy { it.myRating })
        restaurants.forEach{
            println(it.name)
        }
    }

    internal fun sort() {
        val ratings = mutableListOf<FoodReviewModel>()
        foodReviews.forEach {
            ratings.add(it)
        }
        ratings.sortWith(compareBy { it.name })
        ratings.forEach{
            println(it.name)
        }
    }

    internal fun list(): MutableList<FoodReviewModel> {
        val ratings = mutableListOf<FoodReviewModel>()
        foodReviews.forEach {
            ratings.add(it)
        }
        ratings.sortWith(compareBy { it.name })
        return ratings
    }
    }