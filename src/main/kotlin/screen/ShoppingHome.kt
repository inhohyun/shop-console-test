package screen

class ShoppingHome {

    fun start(){
        /*
   Step 1. 인사말 출력
   Step 2. 사용자 이름 받기
   Step 3. 입력 받은 사용자 이름 출력
   */
        showWelcomeMessage()
        showCategories()

    }




    private fun showWelcomeMessage() {
        println("안녕하세요, Shoppi에 오신 것을 환영합니다!")
        println("쇼핑을 계속 하시려면 이름을 입력해주세요 :")


        val name = readLine()

        println(
            """
            감사합니다. 반갑습니다, $name 님 
            원하시는 카테고리를 입력해주세요.
            ***====================================***
        """.trimIndent()
        )
        //trimIndent : /n없이 enter로 라인 넘기기
    }
    private fun showCategories() {
        val categories = arrayOf("패션", "전자기기", "반려동물용품")
        for (category in categories) // for each문 같은 느낌?
        {
            println(category)
        }
        println("=>장바구니로 이동하시려면 #을 입력해주세요.")

        var selectedCategoy = readLine()
        while (selectedCategoy.isNullOrBlank()) { //
            println("값을 입력해 주세요")
            selectedCategoy = readLine()
        }
        if (selectedCategoy == "#") {
            //TODO 1. 장바구니 이동
        } else {
            //TODO 2. 카테고리에 해당하는 상품을 보여주기
            //TODO 3. 카테고리 목록에 없는 값을 입력하는 경우

        }
    }
}