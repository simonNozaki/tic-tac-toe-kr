import csstype.px
import csstype.rgb
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.InputType
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.label
import react.dom.html.ReactHTML.p
import react.useState

external interface WelcomeProps : Props {
    var name: String
    var price: Int
    var quantity: Int
    var total: Int
}

val Welcome = FC<WelcomeProps> { props ->
    var name by useState(props.name)
    var price by useState(props.price)
    var quantity by useState(props.quantity)
    var total by useState(props.total)

    div {
        css {
            padding = 5.px
            backgroundColor = rgb(8, 97, 22)
            color = rgb(56, 246, 137)
        }
        +"Hello, $name"
    }
    input {
        css {
            marginTop = 5.px
            marginBottom = 5.px
            fontSize = 14.px
        }
        type = InputType.text
        value = name
        onChange = { event ->
            name = event.target.value
        }
    }
    label {
        htmlFor = "price"
        +"単価"
    }
    input {
        id = "price"
        type = InputType.number
        value = price
        onChange = { event ->
            price = runCatching { event.target.value.toInt() }.getOrDefault(0)
            total = quantity * price
        }
    }
    label {
        htmlFor = "quantity"
        +"数量"
    }
    input {
        id = "quantity"
        type = InputType.number
        value = quantity
        onChange = { event ->
            quantity = runCatching { event.target.value.toInt() }.getOrDefault(0)
            total = price * quantity
        }
    }
    p {
        +"合計: $total"
    }
}
