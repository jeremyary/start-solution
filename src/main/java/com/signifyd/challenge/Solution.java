package com.signifyd.challenge;

import com.signifyd.challenge.services.RuleSessionService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws Exception {

        if (args.length != 1) {
            System.out.println("Expecting a singular file argument.");
            return;
        }

        CSVParser parser = CSVParser.parse(new File(args[0]), StandardCharsets.UTF_8, CSVFormat.DEFAULT);
        List<CSVRecord> recordList = parser.getRecords();

        RuleSessionService ruleSessionService = new RuleSessionService();
        ruleSessionService.init();

        ruleSessionService.processPurchaseHistory(recordList);

        // You can find the CSVRecord documentation at:
        // https://commons.apache.org/proper/commons-csv/apidocs/org/apache/commons/csv/CSVRecord.html

        // If you are using Java 8, you can parse the LocalDate from the record by:
        // java.time.LocalDate.parse(record.get(0))
    }
}
