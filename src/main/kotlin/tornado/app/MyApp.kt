package tornado.app

import javafx.stage.Stage
import tornado.views.MainView
import tornadofx.*

class MyApp: App(MainView::class){
    override fun start(stage: Stage){
        if (parameters.named["hotreload"] == "true") {
            reloadViewsOnFocus()
            reloadStylesheetsOnFocus()
        }
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