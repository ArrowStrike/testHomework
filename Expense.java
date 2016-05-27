/**
 * Created by Vladislavs on 26.05.2016..
 */
public class Expense {
    private String name;
    private String service;
    private Double amount;

    public Expense(String name, String service, Double amount) {
        this.name = name;
        this.service = service;
        this.amount = amount;
    }

    public Expense() {
    }

    public String getName() {
        return name;
    }

    public String getService() {
        return service;
    }

    public Double getAmount() {
        return amount;
    }

    public void setService(String service) {

        this.service = service;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

}
