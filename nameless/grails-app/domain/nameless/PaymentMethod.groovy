package nameless

class PaymentMethod {

    Payment payment
	Method method
	
	static belongsTo = [Payment, Method]
	
    static constraints = {
    }
	
	static void link(Payment payment, Method method) {
		def pm = PaymentMethod.findByPaymentAndMethod(payment, method)
		if (!pm) {
			pm = new PaymentMethod()
			payment?.addToMethods(pm)
			method?.addToPayments(pm)
			pm.save(flush: true)
		}
	}
	
	static void unlink(Payment payment, Method method) {
		def pm = PaymentMethod.findByPaymentAndMethod(payment, method)
		if (pm) {
			payment?.removeFromMethods(pm)
			method?.removeFromPayments(pm)
			pm.delete(flush: true)
		}
	}
}
