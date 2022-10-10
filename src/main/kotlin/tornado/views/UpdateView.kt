package tornado.views

import javafx.scene.control.TextField
import javafx.scene.paint.Color
import tornadofx.*

class UpdateView : View() {
    var firstNameField: TextField by singleAssign()
    var lastNameField: TextField by singleAssign()
    override val root = hbox {
        label("Update View") {
            textFill = Color.BLUE
        }
        button("Go to Main Menu") {
            textFill = Color.RED
            action {
                replaceWith<MainView>()
                println("Going to Main Menu!")
            }
        }

        button("Go to Add View") {
            textFill = Color.RED
            action {
                replaceWith<AddView>()
                println("Going to AddView!")
            }
        }

        button("Go to Delete View") {
            textFill = Color.RED
            action {
                replaceWith<DeleteView>()
                println("Going to Delete View!")
            }
        }

        button("Go to List Views") {
            textFill = Color.RED
            action {
                replaceWith<ListView>()
                println("Going to ListViews!")
            }
        }
    }
}