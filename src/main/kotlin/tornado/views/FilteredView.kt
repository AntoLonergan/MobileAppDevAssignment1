package tornado.views

import food.review.app.console.models.FoodReviewJSONStore
import food.review.app.console.models.FoodReviewModel
import javafx.scene.paint.Color
import tornadofx.*

class FilterdView : View() {
    val foodReviews = FoodReviewJSONStore()
    val reviews = SortedFilteredList(items = foodReviews.sortedFX().asObservable())
    override val root = vbox(50) {
        label("Filtered View") {
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

            button("Go back to List Views") {
                textFill = Color.RED
                action {
                    replaceWith<ListView>()
                    println("Going to ListViews!")
                }
            }
        }
    }
}



