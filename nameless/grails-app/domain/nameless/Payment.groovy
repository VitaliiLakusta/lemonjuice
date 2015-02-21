package nameless

class Payment {

	String image
	String productName
	BigDecimal price
	
	static hasMany = [methods: PaymentMethod]
	
    static constraints = {
    }
	
	def addToMethods(Method method) {
		PaymentMethod.link(this, method)
	}
	
	def removeFromMethods(Method method) {
		PaymentMethod.unlink(this, method)
	}
}
