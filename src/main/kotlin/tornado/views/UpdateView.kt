package tornado.views

import javafx.scene.paint.Color
import tornadofx.*

class UpdateView : View() {
    override val root = vbox(60){
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

    }
}