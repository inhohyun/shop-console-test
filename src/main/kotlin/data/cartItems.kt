package data

//항상 같은 값을 유지해야하기 때문에 싱글턴 객체로 만들기
object cartItems {
    private val mutableProducts = mutableMapOf<Product, Int>()
    val products: Map<Product, Int> = mutableProducts

    fun addProduct(product: Product){
        mutableProducts[product]?.let {
            mutableProducts[product] = it +1
        } ?: kotlin.run {
            mutableProducts[product] = 1
        }

    }
}