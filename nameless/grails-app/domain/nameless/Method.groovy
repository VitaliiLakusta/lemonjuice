package nameless

class Method {
	
	String name
	String image
	String link

	static hasMany = [payments: PaymentMethod]
	
    static constraints = {
    }
	
	def addToPayments(Payment payment) {
		PaymentMethod.link(payment, this)
	}
	
	def removeFromPayments(Payment payment) {
		PaymentMethod.unlink(payment, this)
	}
}
