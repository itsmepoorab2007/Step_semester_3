// PROBLEM 1: Membership Field Reach Checker
import java.util.*;

public class AccessChecker {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        switch (fieldModifier) {
            case "private":
                return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
            case "default":
                return (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) ? "ALLOWED" : "DENIED";
            case "protected":
                return !accessorContext.equals("DIFFERENT_PACKAGE") ? "ALLOWED" : "DENIED";
            case "public":
                return "ALLOWED";
            default:
                return "DENIED";
        }
    }

    public static String summarizeByModifier(String[][] attempts) {
        Map<String, int[]> stats = new LinkedHashMap<>();
        stats.put("private", new int[]{0, 0});
        stats.put("default", new int[]{0, 0});
        stats.put("protected", new int[]{0, 0});
        stats.put("public", new int[]{0, 0});

        for (String[] attempt : attempts) {
            String mod = attempt[0];
            String ctx = attempt[1];
            String res = classifyAccess(mod, ctx);
            if (stats.containsKey(mod)) {
                if (res.equals("ALLOWED")) {
                    stats.get(mod)[0]++;
                } else {
                    stats.get(mod)[1]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (Map.Entry<String, int[]> entry : stats.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()[0]).append(" allowed / ").append(entry.getValue()[1]).append(" denied");
            if (idx < stats.size() - 1) {
                sb.append(" ");
            }
            idx++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));
    }
}
