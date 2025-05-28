package enums;

public enum PageNaming {
    PRODUCTS("Products"),
    CARTS("Your Cart");
    private final String displayName;

    PageNaming(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}