package com.example.utils

import tornadofx.*

class PopUpBox : Fragment(){
    val message: String by param()
    override val root = vbox {

        label(message){
            setMinSize(100.0,100.0)
        }
    }
}