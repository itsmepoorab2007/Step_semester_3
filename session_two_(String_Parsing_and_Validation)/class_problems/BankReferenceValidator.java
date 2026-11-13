public class BankReferenceValidator {
    public static String normalizeReference(String raw) {
        if (raw == null) return "";
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed;
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return bankCode + rest;
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        String bank = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String formattedDate = date.substring(0, 2) + "/" + date.substring(2, 4) + "/" + date.substring(4, 6);
        String seq = reference.substring(9, 14);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bank).append("] DATE: ").append(formattedDate).append(" | SEQ: ").append(seq);
        return sb.toString();
    }

    public static void main(String[] args) {
        String raw1 = "hdf03022600042";
        System.out.println(validateAndFormat(normalizeReference(raw1)));
        String raw2 = "12F03022600042";
        System.out.println(validateAndFormat(normalizeReference(raw2)));
    }
}
