package cn.stock.model;

public class EastMoneyIndestry {
    private String code;

    private String name;

    public EastMoneyIndestry(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public EastMoneyIndestry() {
        super();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}