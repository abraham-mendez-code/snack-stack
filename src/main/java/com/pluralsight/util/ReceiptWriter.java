package com.pluralsight.util;

import com.pluralsight.models.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    private final String FILE_DIR = "src/main/resources/";

    // constructor
    public ReceiptWriter() {
    }

    public void saveReceipt(Order order) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String fileName = FILE_DIR + now.format(formatter) + ".txt";

        try (BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter(fileName) ) ) {

            bufferedWriter.write(order.getDescription());
            bufferedWriter.close();
        }
        catch (IOException e) {
            System.out.println("Error writing to file ");
            e.printStackTrace();
        }


    }
}
