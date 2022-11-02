package com.projeto.monopoly.service;

import com.projeto.monopoly.model.SlotModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SlotService {
    private SlotModel slot;

    public SlotService(int indexColumn, int indexRow) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("../slots.json"));
        String cardPosition = "column_"+ indexColumn + " row_" + indexRow;
        JSONObject cardJson = (JSONObject) jsonObject.get(cardPosition);

        //this.slot = new SlotModel("teste", "alguem", 200, 200, "room");
        System.out.println(cardJson);
    }
    public SlotModel getSlot() {
        return this.slot;
    }
}
