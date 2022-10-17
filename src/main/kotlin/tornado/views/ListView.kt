package tornado.views

import food.review.app.console.models.FoodReviewJSONStore
import food.review.app.console.models.FoodReviewModel
import food.review.app.console.views.FoodReviewView
import javafx.scene.paint.Color
import tornadofx.*

class ListView : View() {
    override val root = vbox(50) {
        label("List View") {
            textFill = Color.BLUE
        }
        button("Go to Main Menu") {
            textFill = Color.RED
            action {
                replaceWith<MainView>()
                println("Going to Main Menu!")
            }
        }

            tableview {

                column("ID", FoodReviewModel::id)
                column("Name", FoodReviewModel::name)
                column("Address", FoodReviewModel::address)
                column("PostCode", FoodReviewModel::address)
                column("Just Eat Rating", FoodReviewModel::justEatRating)
                column("PostCode", FoodReviewModel::postCode)
                column("Items", FoodReviewModel::items)
                column("Price", FoodReviewModel::price)
                column("Comments", FoodReviewModel::comments)
                column("My Rating", FoodReviewModel::myRating)
            }
        FoodReviewView().listFoodReviews(foodReviews = FoodReviewJSONStore())
        }
    }

