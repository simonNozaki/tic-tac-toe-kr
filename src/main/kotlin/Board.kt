import csstype.px
import emotion.react.css
import org.w3c.dom.HTMLButtonElement
import react.FC
import react.Props
import react.dom.events.MouseEventHandler
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.ol
import react.useState

external interface GameProps : Props

external interface BoardProps : Props {
    var isXNext: Boolean
    var squares: List<String>
    var onPlay: (List<String>) -> Unit
}

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

val Board = FC<BoardProps> { props ->
    fun handleClick(index: Int): MouseEventHandler<HTMLButtonElement> = {
        if (props.squares[index].isEmpty()) {
            val nextSquares = props.squares.toMutableList()
            nextSquares[index] = if (props.isXNext) "X" else "O"
            props.onPlay(nextSquares)
        }
    }
    val winner = GameRule(props.squares).getWinner()
    var status = ""
    status = if (winner == "\$NONE") "Next player is: ${if (props.isXNext) "X" else "O"}" else "Winner: $winner"

    div {
        css {
            marginBottom = 10.px
        }
        +status
    }
    div {
        css(styleBorderRow)
        Square {
            value = props.squares[0]
            onSquareClick = handleClick(0)
        }
        Square {
            value = props.squares[1]
            onSquareClick = handleClick(1)
        }
        Square {
            value = props.squares[2]
            onSquareClick = handleClick(2)
        }
    }
    div {
        css(styleBorderRow)
        Square {
            value = props.squares[3]
            onSquareClick = handleClick(3)
        }
        Square {
            value = props.squares[4]
            onSquareClick = handleClick(4)
        }
        Square {
            value = props.squares[5]
            onSquareClick = handleClick(5)
        }
    }
    div {
        css(styleBorderRow)
        Square {
            value = props.squares[6]
            onSquareClick = handleClick(6)
        }
        Square {
            value = props.squares[7]
            onSquareClick = handleClick(7)
        }
        Square {
            value = props.squares[8]
            onSquareClick = handleClick(8)
        }
    }
}

val Game = FC<GameProps> {
    var isXNext by useState(true)
    var history by useState(mutableListOf(MutableList(9) { "" }))
    val currentSquares = history.last()
    fun handlePlay(): (List<String>) -> Unit = { squares: List<String> ->
        isXNext = !isXNext
        val nextHistory = history.toMutableList()
        nextHistory.add(squares.toMutableList())
        history = nextHistory
    }

    div {
        css(styleGame)
        div {
            css(styleGameBoard)
            Board {
                isXNext = !isXNext
                squares = currentSquares
                onPlay = handlePlay()
            }
        }
        div {
            css(styleGameInfo)
            ol {}
        }
    }
}
