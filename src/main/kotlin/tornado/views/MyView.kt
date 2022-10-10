package tornado.views

import tornado.styles.Styles
import tornadofx.*

class MyView : View("Food Review") {
    override val root = borderpane {
        label(title) {
            addClass(Styles.heading)
        }
    }
}
