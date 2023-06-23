package main;

public abstract class ProductCategory {
    private String name;
    private String description;

    public ProductCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

