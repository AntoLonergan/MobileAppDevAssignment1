package tornado.app

import javafx.stage.Stage
import tornado.views.MainView
import tornadofx.*

class MyApp: App(MainView::class){
    override fun start(stage: Stage){
        with(stage){
            width = 1000.0
            height = 1000.0
        }
        super.start(stage)
    }
}

fun main() {
    launch<MyApp>()
}