package screen

import data.Product
import data.cartItems
import extensions.getNotEmptyInt
import extensions.getNotEmptyString

class ShoppingProductList {
    private val products = arrayOf(
        Product("패션", "겨울 패딩"),
        Product("패션", "겨울 바지"),
        Product("전자기기", "핸드폰"),
        Product("전자기기", "블루투스 이어폰"),
        Product("전자기기", "노트북"),
        Product("반려동물용품", "건식사료"),
        Product("반려동물용품", "습식사료"),
        Product("반려동물용품", "치약"),
        Product("반려동물용품", "간식")

    )

    private val categories: Map<String, List<Product>> = products.groupBy { product ->
        product.categoryLabel
    }

    fun showProducts(selectedCategory: String){
        val categoryProducts = categories[selectedCategory]
        if(!categoryProducts.isNullOrEmpty()){
            println("""
                ***==========================================***
                선택하신[$selectedCategory] 카테고리 상품입니다.
            """.trimIndent())
//            val productSize = categoryProducts.size
//            for(index in 0 until productSize){
//                println("${index}. ${categoryProducts[index].name}")
//            }

            //고차함수를 사용해 index값과 value 값 출력
            categoryProducts.forEachIndexed{index, product ->
            println("${index}. ${product.name}")}

            showCartOption(categoryProducts, selectedCategory)
        }
        else{
          //  showEmptyproductMessage(selectedCategory)
        }
    }
    private fun showCartOption(categoryProducts: List<Product>, selectedCategory: String){
        println(
            """
                ***=====================================***
                장바구니에 담을 상품 번호를 선택해주세요.
            """.trimIndent()
        )

        val selectedIndex = readLine().getNotEmptyInt()
        categoryProducts.getOrNull(selectedIndex)?.let{product ->
            cartItems.addProduct(product)
            println("=> 장바구니로 이동하시려면 #을, 계속 쇼핑하시려면 *을 입력해주세요.")
            val answer = readLine().getNotEmptyString()
            if(answer == "#"){
                val shoppingCart = ShoppingCart()
                shoppingCart.showCartItems()
            }else if (answer == "*"){
                showProducts(selectedCategory)
            }
            else{
                //TODO 그 외 값을 입력한 경우에 대한 처리
            }
        }
    }
}