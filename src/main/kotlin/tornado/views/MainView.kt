package tornado.views

import javafx.scene.paint.Color
import tornadofx.*

class MainView : View() {
            override val root =vbox(60) {
                label("Main Menu") {
                    textFill = Color.BLUE
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


                button("Go to List Views") {
                    textFill = Color.RED
                    action {
                        replaceWith<ListView>()
                        println("Going to ListViews!")
                    }
                }

                button("Go to Sorted by Rating View") {
                    textFill = Color.RED
                    action {
                        replaceWith<SortedView>()
                        println("Going to Sorted View!")
                    }
                }
            }
        }







