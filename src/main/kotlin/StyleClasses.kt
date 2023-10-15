import csstype.*

val styleSquare: PropertiesBuilder.() -> Unit = {
    backgroundColor = rgb(255, 255, 255)
    float = Float.left
    fontSize = 24.px
    fontWeight = FontWeight.bold
    lineHeight = 34.px
    height = 34.px
    marginRight = (1 * -1).px
    marginTop = (1 * -1).px
    padding = 0.px
    textAlign = csstype.TextAlign.center
    width = 34.px
}

val styleBorderRow: PropertiesBuilder.() -> Unit = {
    clear = Clear.both
    display = Display.table
}

val styleGame: PropertiesBuilder.() -> Unit = {
    display = Display.flex
    flexDirection = FlexDirection.row
}

val styleGameBoard: PropertiesBuilder.() -> Unit = {
}

val styleGameInfo: PropertiesBuilder.() -> Unit = {
    marginLeft = 20.px
}
