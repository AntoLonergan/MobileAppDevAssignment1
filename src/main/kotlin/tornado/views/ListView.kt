package tornado.views

import javafx.scene.paint.Color
import tornadofx.*

class ListView : View() {
    override val root = vbox {
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

        button("Go to Add View") {
            textFill = Color.RED
            action {
                replaceWith<AddView>()
                println("Going to Add View!")
            }

        }
        button("Go to Update View") {
            textFill = Color.RED
            action {
                replaceWith<UpdateView>()
                println("Going to Update View!")
            }
        }

        button("Go to Delete View") {
            textFill = Color.RED
            action {
                replaceWith<DeleteView>()
                println("Going to Delete View!")
            }

        }
    }
}