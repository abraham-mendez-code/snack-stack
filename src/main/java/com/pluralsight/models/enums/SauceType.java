package com.pluralsight.models.enums;

public enum SauceType {
    MAYO("Mayo"),
    MUSTARD("Mustard"),
    KETCHUP("Ketchup"),
    RANCH("Ranch"),
    BBQ("BBQ"),
    THOUSAND_ISLAND("Thousand Island"),
    VINAIGRETTE("Vinaigrette");

    private final String displayName;

    SauceType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }

}
