import csstype.px
import emotion.react.css
import org.w3c.dom.HTMLButtonElement
import react.FC
import react.Props
import react.dom.events.MouseEventHandler
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.useState

external interface BoardProps : Props

external interface SquareProps : Props {
    var value: String
    var onSquareClick: MouseEventHandler<HTMLButtonElement>
}

val Square = FC<SquareProps> { props ->

    button {
        css(styleSquare)
        onClick = props.onSquareClick
        +props.value
    }
}

val Board = FC<BoardProps> {
    var isXNext by useState(true)
    var values by useState(MutableList(9) { "" })
    fun handleClick(index: Int): MouseEventHandler<HTMLButtonElement> = {
        if (values[index].isEmpty()) {
            val nextSquares = values.toMutableList()
            nextSquares[index] = if (isXNext) "X" else "O"
            values = nextSquares
            isXNext = !isXNext
        }
    }
    val winner = GameRule(values).getWinner()
    var status: String = ""
    status = if (winner == "\$NONE") "Next player is: ${if (isXNext) "X" else "O"}" else "Winner: $winner"

    div {
        css {
            marginBottom = 10.px
        }
        +status
    }
    div {
        css(styleBorderRow)
        Square {
            value = values[0]
            onSquareClick = handleClick(0)
        }
        Square {
            value = values[1]
            onSquareClick = handleClick(1)
        }
        Square {
            value = values[2]
            onSquareClick = handleClick(2)
        }
    }
    div {
        css(styleBorderRow)
        Square {
            value = values[3]
            onSquareClick = handleClick(3)
        }
        Square {
            value = values[4]
            onSquareClick = handleClick(4)
        }
        Square {
            value = values[5]
            onSquareClick = handleClick(5)
        }
    }
    div {
        css(styleBorderRow)
        Square {
            value = values[6]
            onSquareClick = handleClick(6)
        }
        Square {
            value = values[7]
            onSquareClick = handleClick(7)
        }
        Square {
            value = values[8]
            onSquareClick = handleClick(8)
        }
    }
}
