package screen

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
            //TODO 1. 장바구니 이동
        } else {

            if (categories.contains(selectedCategoy)){
                //TODO 2. 카테고리에 해당하는 상품을 보여주기
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