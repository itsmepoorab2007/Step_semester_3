public class FileExtensionValidator {
    public static String validateFileExtension(String filename) {
        if (filename == null) return "Rejected — invalid file type";
        int lastDot = filename.lastIndexOf('.');
        if (lastDot == -1 || lastDot == filename.length() - 1) {
            return "Rejected — invalid file type";
        }
        String ext = filename.substring(lastDot + 1).toLowerCase();
        if (ext.equals("pdf") || ext.equals("docx") || ext.equals("zip")) {
            return "Accepted";
        }
        return "Rejected — invalid file type";
    }
    public static void main(String[] args) {
        System.out.println(validateFileExtension("Assignment1.PDF"));
        System.out.println(validateFileExtension("notes.txt"));
    }
}
