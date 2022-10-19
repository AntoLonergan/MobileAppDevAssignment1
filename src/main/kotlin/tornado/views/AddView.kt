package tornado.views

import com.example.utils.PopUpBox
import food.review.app.console.models.FoodReviewJSONStore
import food.review.app.console.models.FoodReviewModel
import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.TextField
import javafx.scene.paint.Color
import tornadofx.*

private var nameField: TextField by singleAssign()
private var addressField: TextField by singleAssign()
private var postCodeField: TextField by singleAssign()
private var justEatRatingField: TextField by singleAssign()
private var itemsField: TextField by singleAssign()
private var priceField: TextField by singleAssign()
private var commentsField: TextField by singleAssign()
private var myRatingField: TextField by singleAssign()
private val foodReviews = FoodReviewJSONStore()


private var nameString = SimpleStringProperty()
private var addressString = SimpleStringProperty()
private var postCodeString = SimpleStringProperty()
private var justEatRatingString = SimpleDoubleProperty()
private var itemsString = SimpleStringProperty()
private var priceString = SimpleDoubleProperty()
private var commentsString = SimpleStringProperty()
private var myRatingString = SimpleIntegerProperty()


class AddView : View() {
    override val root = vbox(60) {
        label("Add View") {
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

                field("Restaurant Name")
                nameField = textfield(nameString) {
                    promptText = "e.g Joe's"
                }

                field("Restaurant Address")
                addressField = textfield(addressString) {
                    promptText = "e.g"
                }

                field("Restaurant Post Code")
                postCodeField = textfield(postCodeString) {
                    promptText = "e.g Restaurant Post Code"
                }

                field("Restaurant Just Eat Rating")
                justEatRatingField = textfield(justEatRatingString) {
                    promptText = "e.g 7.73"
                }

                field("What items did you buy?")
                itemsField = textfield(itemsString) {
                    promptText = "e.g Chicken Wings"
                }

                field("Price?")
                priceField = textfield(priceString) {
                    promptText = "e.g 7.50"
                }

                field("Comments")
                commentsField = textfield(commentsString) {
                    promptText = "e.g Great"
                }

                field("Your Rating?")
                myRatingField = textfield(myRatingString) {
                    promptText = "e.g 9"
                }

                priceField.clear()
                myRatingField.clear()
                justEatRatingField.clear()
                button("Add") {
                    action {
                        val aFoodReview = FoodReviewModel(
                            0,
                            nameString.value, addressString.value, postCodeString.value, justEatRatingString.value,
                            itemsString.value,
                            priceString.value,
                            commentsString.value,
                            myRatingString.value
                        )
                        foodReviews.create(aFoodReview)
                        nameField.clear()
                        addressField.clear()
                        postCodeField.clear()
                        justEatRatingField.clear()
                        itemsField.clear()
                        priceField.clear()
                        commentsField.clear()
                        myRatingField.clear()
                        find<PopUpBox>(params = mapOf("message" to "Add Successful!")).openModal()
                    }
                }
            }
        }
    }
}


