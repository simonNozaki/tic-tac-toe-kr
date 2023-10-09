import csstype.Clear
import csstype.Display
import csstype.Float
import csstype.FontWeight
import csstype.PropertiesBuilder
import csstype.px
import csstype.rgb

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
