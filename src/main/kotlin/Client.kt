import kotlinx.browser.document // ktlint-disable filename
import react.create
import react.dom.client.createRoot

fun main() {
    val root = document.getElementById("root") ?: throw RuntimeException("root must be set in index.html")
    createRoot(root).render(Game.create())
}
