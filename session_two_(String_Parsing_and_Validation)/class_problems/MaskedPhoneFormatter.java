public class MaskedPhoneFormatter {
    public static void maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            System.out.println("Invalid phone number");
            return;
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                System.out.println("Invalid phone number");
                return;
            }
        }
        String last4 = phone.substring(6);
        StringBuilder sb = new StringBuilder("XXXXXX-");
        sb.append(last4);
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        maskPhoneNumber("9876543210");
        maskPhoneNumber("98765");
    }
}
