package tornado.views

import food.review.app.console.models.FoodReviewJSONStore
import food.review.app.console.models.FoodReviewModel
import javafx.scene.paint.Color
import tornadofx.*

class SortedView : View() {
    val foodReviews = FoodReviewJSONStore()
    val reviews = SortedFilteredList(items = foodReviews.sortedFX().asObservable())
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
        tableview<FoodReviewModel> {
            items = reviews
            columnResizePolicy = SmartResize.POLICY

            column("ID", Long::class) {
                value {
                    it.value.id
                }
                remainingWidth()
            }


            column("Name", String::class) {
                value {
                    it.value.name
                }
                remainingWidth()
            }
            column("Address", String::class) {
                value {
                    it.value.address
                }
                remainingWidth()
            }
            column("Postcode", String::class) {
                value {
                    it.value.postCode
                }
                remainingWidth()
            }
            column("JustEatRating", Double::class) {
                value {
                    it.value.justEatRating
                }
                remainingWidth()
            }

            column("Items", String::class) {
                value {
                    it.value.items
                }
                remainingWidth()
            }


            column("Price", Double::class) {
                value {
                    it.value.price
                }
                remainingWidth()
            }

            column("Comments", String::class) {
                value {
                    it.value.comments
                }
                remainingWidth()
            }

            column("My Rating", Int::class) {
                value {
                    it.value.myRating
                }
                remainingWidth()
            }
        }
        button("Go back to List Views") {
            textFill = Color.RED
            action {
                replaceWith<ListView>()
                println("Going to ListViews!")
            }
        }
    }
}