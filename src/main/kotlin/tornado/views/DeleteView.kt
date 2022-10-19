package tornado.views

import food.review.app.console.models.FoodReviewJSONStore
import javafx.beans.property.SimpleLongProperty
import javafx.scene.control.TextField
import javafx.scene.paint.Color
import tornado.helpers.PopUpBox
import tornadofx.*

private var idField: TextField by singleAssign()
private var idString = SimpleLongProperty()
private val foodReviews = FoodReviewJSONStore()

class DeleteView : View() {
    override val root = vbox(60) {
        label("Delete View") {
            textFill = Color.BLUE
        }

        button("Go to Main Menu") {
            textFill = Color.RED
            action {
                replaceWith<MainView>()
                println("Going to Main Menu!")
            }
        }

        form {
            setPrefSize(230.0, 600.0)
            fieldset {

                field("ID to Delete")
                idField = textfield(idString) {
                    promptText = "842084929432890"
                }
                idField.clear()

                button("Delete") {
                    action {
                            val searchId = idString.value
                            val dFoodReview = foodReviewController.search(searchId)
                            if (dFoodReview != null) {
                                foodReviews.delete(dFoodReview)
                                idField.clear()
                                find<PopUpBox>(params = mapOf("message" to "Successfully Deleted")).openModal()
                            } else {
                                idField.clear()
                                find<PopUpBox>(params = mapOf("message" to "Could not Complete Deletion Make Sure Valid Number was Input!")).openModal()
                            }
                        }
                    }
                }
            }
    }
}