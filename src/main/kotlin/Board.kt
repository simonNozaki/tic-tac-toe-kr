import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.useState

external interface BoardProps : Props

external interface SquareProps : Props

val Square = FC<SquareProps> {
    var value by useState<String>()

    button {
        css(styleSquare)
        onClick = { value = "X" }
        if (value != null) {
            +value!!
        }
    }
}

val Board = FC<BoardProps> {
    div {
        css(styleBorderRow)
        Square()
        Square()
        Square()
    }
    div {
        css(styleBorderRow)
        Square()
        Square()
        Square()
    }
    div {
        css(styleBorderRow)
        Square()
        Square()
        Square()
    }
}
