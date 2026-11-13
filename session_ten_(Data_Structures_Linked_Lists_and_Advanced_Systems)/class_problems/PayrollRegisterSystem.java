// PRACTICE PROBLEM 5: Payroll Register System
abstract class Staff {
    protected String name;
    protected String type;
    public Staff(String name, String type) { this.name = name; this.type = type; }
    public abstract double calculatePay();
    public String toString() {
        return "Payslip[name=" + name + ", type=" + type + ", pay=" + (int)calculatePay() + "]";
    }
}

class FullTimeStaff extends Staff {
    private double salary;
    public FullTimeStaff(String name, double salary) { super(name, "FullTime"); this.salary = salary; }
    @Override public double calculatePay() { return salary; }
}

class PartTimeStaff extends Staff {
    private double hours, rate;
    public PartTimeStaff(String name, double hours, double rate) { super(name, "PartTime"); this.hours = hours; this.rate = rate; }
    @Override public double calculatePay() { return hours * rate; }
}

class InternStaff extends Staff {
    private double stipend;
    public InternStaff(String name, double stipend) { super(name, "Intern"); this.stipend = stipend; }
    @Override public double calculatePay() { return stipend; }
}

public class PayrollRegisterSystem {
    public static void main(String[] args) {
        Staff[] staffList = {
            new FullTimeStaff("Asha", 50000),
            new PartTimeStaff("Ravi", 80, 300),
            new InternStaff("Neha", 15000)
        };
        double total = 0;
        double maxPay = -1;
        String topEarner = "";

        for (Staff s : staffList) {
            System.out.println(s);
            double pay = s.calculatePay();
            total += pay;
            if (pay > maxPay) {
                maxPay = pay;
                topEarner = s.name;
            }
        }
        System.out.println("Total " + (int)total);
        System.out.println("top earner " + topEarner);
    }
}
