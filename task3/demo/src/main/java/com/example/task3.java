package com.example;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;

public class task3 {
    //Это не работает, но я попытался..
    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Wrong input. One file path is expected.");
           return;
        }

        String valuesJson = args[0];
        String testsJson = args[1];
        String reportJson = args[2];

        ObjectMapper mapper = new ObjectMapper();

        try {
            // Reading values, tests and merge them
            JsonNode valuesNode = mapper.readTree(new File(valuesJson));
            JsonNode testsNode = mapper.readTree(new File(testsJson));
            JsonNode reportNode = mergeValues(valuesNode, testsNode);

            mapper.writeValue(new File(reportJson), reportNode);
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
    }

    private static JsonNode mergeValues(JsonNode valuesNode, JsonNode testsNode) {
        ObjectNode reportNode = (ObjectNode) testsNode.deepCopy();
        System.out.println(reportNode);
        //Not working.
        for (JsonNode node : reportNode) {
            if (node.has("value")) {
                String value = valuesNode.get(node.get("id").asText()).asText();
                ((ObjectNode) node).put("value", value);
            } else if (node.has("values")) {
                ArrayNode childrenNode = (ArrayNode) node.get("values");
                for (JsonNode childNode : childrenNode) {
                    mergeValues(valuesNode, childNode);
                }
            }
        }
        return reportNode;
    }
}