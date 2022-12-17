package screen

//화면이동에 관한 전반적인걸 담당하므로 싱글톤 객체로 생성
object ScreenStack {
    private val screenStack = mutableListOf<Screen>()

    fun push(screen: Screen){
        screenStack.add(screen)
    }

    fun pop(){
        screenStack.removeLastOrNull()
    }

    fun peek(): Screen?{
        return screenStack.lastOrNull()
    }
}

sealed class Screen