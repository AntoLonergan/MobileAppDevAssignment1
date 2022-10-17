package food.review.app.console.controllers

import food.review.app.console.models.FoodReviewJSONStore
import food.review.app.console.models.FoodReviewModel
import food.review.app.console.views.FoodReviewView
import mu.KotlinLogging

class FoodReviewController {

    val foodReviews = FoodReviewJSONStore()
    val foodReviewView = FoodReviewView()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching Food Review Console App" }
        println("Food Review Kotlin App by Anthony Lonergan")
    }

    fun start() {
        var input: Int

        do {
            input = menu()
            when (input) {
                1 -> add()
                2 -> update()
                3 -> delete()
                4 -> list()
                5 -> search()
                6 -> restaurants()
                7 -> sort()
                -1 -> println("Exiting App")
                else -> println("Invalid Option")
            }
            println()
        } while (input != -1)
        logger.info { "Shutting Down Placemark Console App" }
    }

    fun menu() :Int { return foodReviewView.menu() }

    fun add(){
        var aFoodReview = FoodReviewModel()

        if (foodReviewView.addFoodReviewData(aFoodReview))
            foodReviews.create(aFoodReview)
        else
            logger.info("Food Review Not Added")
    }

    fun list() {
        foodReviewView.listFoodReviews(foodReviews)
    }

    fun update() {

        foodReviewView.listFoodReviews(foodReviews)
        var searchId = foodReviewView.getId()
        val aFoodReview = search(searchId)

        if(aFoodReview != null) {
            if(foodReviewView.updateFoodReviewData(aFoodReview)) {
                foodReviews.update(aFoodReview)
                foodReviewView.showFoodReviews(aFoodReview)
                logger.info("Food Review Updated : [ $aFoodReview ]")
            }
            else
                logger.info("Food Review Not Updated")
        }
        else
            println("Food Review Not Updated...")
    }

    fun delete() {
        foodReviewView.listFoodReviews(foodReviews)
        var searchId = foodReviewView.getId()
        val aFoodReview = search(searchId)

        if(aFoodReview != null) {
            foodReviews.delete(aFoodReview)
            println("Food Review Deleted...")
            foodReviewView.listFoodReviews(foodReviews)
        }
        else
            println("Food Reviews Not Deleted...")
    }


    fun restaurants(){
        foodReviews.restaurants()
    }

    fun sort(){
        foodReviews.sort()
    }

    fun search() {
        val aFoodReview = search(foodReviewView.getId())!!
        foodReviewView.showFoodReviews(aFoodReview)
    }


    fun search(id: Long) : FoodReviewModel? {
        var foundFoodReviews = foodReviews.findOne(id)
        return foundFoodReviews
    }

}