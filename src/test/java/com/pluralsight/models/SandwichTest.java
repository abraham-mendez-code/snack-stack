package com.pluralsight.models;

import com.pluralsight.models.enums.BreadType;
import com.pluralsight.models.enums.CheeseType;
import com.pluralsight.models.enums.MeatType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {

    /**
     * Test condition for a 4" sandwich with one meat and one cheese.
     * Validates that the total price equals the base price plus the prices of
     * included meat, cheese, and any toppings.
     */

    @Test
    void basicSandwich() {

        // ARRANGE
        Sandwich basicSandwich = new Sandwich(BreadType.WHITE, 4, false);

        // ACT
        double actualTotal = basicSandwich.getValue();
        basicSandwich.addMeat(MeatType.CHICKEN, false);
        basicSandwich.addCheese(CheeseType.CHEDDAR, false);
        double expectedTotal = BreadType.WHITE.getPriceForSize(4) + MeatType.CHICKEN.getPriceForSize(4) + CheeseType.CHEDDAR.getPriceForSize(4);

        // ASSERT
        Assertions.assertEquals(actualTotal, expectedTotal);
    }


}