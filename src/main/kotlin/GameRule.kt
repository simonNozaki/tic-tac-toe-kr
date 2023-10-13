/**
 * ゲームのルール、とくに勝者決定ロジックのドメインクラス
 */
data class GameRule(
    val squares: List<String>
) {
    private val lines = listOf(
        listOf(0, 1, 2),
        listOf(3, 4, 5),
        listOf(6, 7, 8),
        listOf(0, 3, 6),
        listOf(1, 4, 7),
        listOf(2, 5, 8),
        listOf(0, 4, 8),
        listOf(2, 4, 6)
    )

    init {
        if (squares.size != 9) throw RuntimeException()
    }

    fun getWinner(): String {
        val winning = lines.firstOrNull { squares[it[0]] == squares[it[1]] && squares[it[0]] == squares[it[2]] }
        return if (winning.isNullOrEmpty()) "\$NONE" else squares[winning[0]]
    }
}
