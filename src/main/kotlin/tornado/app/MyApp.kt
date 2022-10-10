package tornado.app

import javafx.stage.Stage
import tornado.styles.Styles
import tornado.views.MainView
import tornadofx.*

class MyApp: App(MainView::class, Styles::class){
    override fun start(stage: Stage){
        with(stage){
            width = 600.0
            height = 670.0
        }
        super.start(stage)
    }
}

fun main() {
    launch<MyApp>()
}