package screen

import data.Product
import data.cartItems
import java.io.File.separator

class ShoppingCart : Screen(){
    private val products = cartItems.products

    fun showCartItems(){
        ScreenStack.push(this)
        if (products.isNotEmpty()){
            println(
                products.keys.joinToString (
                    separator =", \n",
                    prefix = """
                        ***====================================***
                        장바구니에 담은 상품 목록 입니다.
                    """.trimIndent()

            ){ product ->
                    "카테고리: ${product.categoryLabel} / 상품명: ${product.name} / 수량: ${products[product]}"
            }
           )
        }else{
            println("""장바구니에 담긴 상품이 없습니다.
                |
            """.trimIndent())
            }
    }

}
