package screen

/*
Step 1. 장바구니에 추가한 상품 관리
Step 2. 사용자 입력값 요청 처리 공통화
Step 3. 프로젝트 전역에서 참조하는 상수
* */

class ShoppingCategory {
    fun showCategories() {
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
            val shoppingCart = ShoppingCart()
            shoppingCart.showCartItems()
        } else {

            if (categories.contains(selectedCategoy)){

                val shoppingProductList = ShoppingProductList()
                shoppingProductList.showProducts(selectedCategoy)
            }else{
                showErrorMessage(selectedCategoy)
            }


        }
    }

    private fun showErrorMessage(selectedCategoy: String?) {
        println("[$selectedCategoy] : 존재하지 않는 카테고리 입니다. 다시 입력해 주세요.")
        showCategories()
    }

}