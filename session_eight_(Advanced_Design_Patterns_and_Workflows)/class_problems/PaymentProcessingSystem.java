// QUESTION 5: Payment Processing for a Shopping System
interface PaymentMethod {
    boolean processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        return true; // Success
    }
}

class PayPalPayment implements PaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        return false; // Failure
    }
}

class Order {
    private String customerName;
    private int itemCount;
    private String status = "Pending";

    public Order(String customerName, int itemCount) {
        this.customerName = customerName;
        this.itemCount = itemCount;
    }

    public int getItemCount() { return itemCount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

public class PaymentProcessingSystem {
    public static void main(String[] args) {
        Order orderX = new Order("Customer X", 3);
        System.out.println("Order created for Customer X.");
        System.out.println("Payment initiated via Credit Card for Order X.");
        PaymentMethod cc = new CreditCardPayment();
        if(cc.processPayment(150.0)) {
            orderX.setStatus("Paid");
            System.out.println("Payment for Order X successful. Order status: " + orderX.getStatus());
        }

        Order orderY = new Order("Customer Y", 0);
        if(orderY.getItemCount() == 0) {
            System.out.println("Cannot process payment for an empty order.");
        }

        Order orderZ = new Order("Customer Z", 1);
        System.out.println("Order created for Customer Z.");
        System.out.println("Payment initiated via PayPal for Order Z.");
        PaymentMethod paypal = new PayPalPayment();
        if(!paypal.processPayment(50.0)) {
            System.out.println("Payment for Order Z failed. Order status: " + orderZ.getStatus());
        }
    }
}
