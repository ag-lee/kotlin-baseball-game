class BaseballGame (maxLength : Int?) {
    private val DEFAULT_LENGTH = 3

    private val maxLength : Int
    private val numbers : String

    init {
        this.maxLength = maxLength ?: DEFAULT_LENGTH
        this.numbers = (100 until 1000).random().toString()
    }

    fun startGame() {
        while (!startRound());

        print("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    private fun startRound() : Boolean {
        print("숫자를 입력해주세요 ex)123 : ")
        val inputs : String? = readLine()

        var strikeCount = 0
        var ballCount = 0

        for (i in 0 until maxLength) {
            var input = inputs?.get(i)?: ' '

            if (numbers[i] == input) {
                strikeCount++
            } else if (numbers.contains(input)) {
                ballCount++
            }
        }

        return isWin(strikeCount, ballCount)
    }

    private fun isWin(strikeCount : Int, ballCount : Int) : Boolean {
        if (strikeCount == 0 && ballCount == 0) {
            print("낫싱\n")
            return false
        }

        val strikeResult = if (strikeCount > 0) "$strikeCount 스트라이크" else ""
        val ballResult = if (ballCount > 0) "$ballCount 볼" else ""

        print("$strikeResult $ballResult\n")

        return (strikeCount == maxLength)
    }

}