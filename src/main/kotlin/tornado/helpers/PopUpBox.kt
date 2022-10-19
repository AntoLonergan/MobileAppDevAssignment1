package tornado.helpers

import tornadofx.*

class PopUpBox : Fragment(){
    private val message: String by param()
    override val root = vbox {

        label(message){
            setMinSize(100.0,100.0)
        }
    }
}