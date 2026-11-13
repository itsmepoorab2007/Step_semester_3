// PROBLEM 5: Immutable Loan Receipt & Nightly Circulation Ledger
public final class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = (bookIds != null) ? bookIds.clone() : new String[0];
    }

    public String getMemberId() {
        return memberId;
    }

    public String[] getBookIds() {
        return bookIds.clone(); // Defensive copy OUT
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        String[] newIds = this.bookIds.clone();
        if (index >= 0 && index < newIds.length) {
            newIds[index] = newId;
        }
        return new LoanReceipt(this.memberId, newIds);
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {
    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}

class CirculationLedger {
    static String branchCode;

    static {
        branchCode = "SRM-CENTRAL-01";
    }

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        int regularCount = 0;
        int refOnlyCount = 0;
        int nullCount = 0;

        if (receipts == null) {
            return "0 processed | 0 null skipped | 0 reference-only | 0 regular";
        }

        for (LoanReceipt r : receipts) {
            if (r == null) {
                nullCount++;
                continue;
            }
            if (r instanceof ReferenceOnlyLoanReceipt) {
                refOnlyCount++;
            } else {
                regularCount++;
            }
        }

        int totalProcessed = regularCount + refOnlyCount;
        return totalProcessed + " processed | " + nullCount + " null skipped | " + refOnlyCount + " reference-only | " + regularCount + " regular";
    }

    public static void main(String[] args) {
        LoanReceipt[] receipts = {
            new ReferenceOnlyLoanReceipt("LIB-001", new String[]{"BK-200"}, "Reading Room 3"),
            null,
            new LoanReceipt("LIB-002", new String[]{"BK-201"})
        };
        System.out.println(processNightlyCirculation(receipts));
    }
}
