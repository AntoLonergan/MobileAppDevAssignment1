package tornado.views

import javafx.scene.paint.Color
import tornadofx.*

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
    }
}