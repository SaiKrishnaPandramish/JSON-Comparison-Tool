package com.compare;


import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class ContentClass {

	public static StringBuilder ValidateJson(String JSON1, String JSON2, String JSON3) {
	 
	
	
   // public static void main(String[] args) {
       JsonElement Json1=getJson1(JSON1);
        JsonElement Json2=getJson2(JSON2);
        JsonElement Json3=getJson3(JSON3);

        StringBuilder obj = new StringBuilder("Execution Results");
        
        
        Gson g = new Gson();
        Type mapType = new TypeToken<Map<String, Object>>() {
        }.getType();
        Map<String, Object> firstMap = g.fromJson(Json1, mapType);
        Map<String, Object> secondMap = g.fromJson(Json2, mapType);
        MapDifference<String, Object> difference = Maps.difference(firstMap, secondMap);

        //System.out.println("\n\nEntries are missing in Json2\n--------------------------\n");
        obj.append("\n\nEntries are missing in Json2\n--------------------------\n");
        difference.entriesOnlyOnLeft().forEach((key, value) -> 
        //System.out.println("\n--> " + key + ": " + value)
        obj.append("\n--> " + key + ": " + value));

      //  System.out.println("\n\nEntries are missing in Json1\n--------------------------\n");
        obj.append("\n\nEntries are missing in Json1\n--------------------------\n");
        difference.entriesOnlyOnRight().forEach((key, value) -> 
      //System.out.println("\n--> " + key + ": " + value)
        obj.append("\n--> " + key + ": " + value));

       // System.out.println("\n\nEntries Mismatching:\n--------------------------\n");
        obj.append("\n\nEntries Mismatching:\n--------------------------\n");
        difference.entriesDiffering().forEach((key, value) -> 
      //System.out.println("\n--> " + key + ": " + value)
        obj.append("\n--> " + key + ": " + value));

        //System.out.println("\n\nEntries Common:\n--------------------------\n");
        obj.append("\n\nEntries Common:\n--------------------------\n");
        difference.entriesInCommon().forEach((key, value) -> 
      //System.out.println("\n--> " + key + ": " + value)
        obj.append("\n--> " + key + ": " + value));
        
        
		return obj;
        
     
        
    }
	
	 public static JsonElement getJson1(String Path) {
	        JsonParser jsonParser = new JsonParser();
	        JsonElement jsonElement=null;
	        try {
	            FileReader fileReader = new FileReader(Path);//Json1 filePath
	            jsonElement = jsonParser.parse(fileReader);
	        } catch (Exception e) {
	            System.out.println("File not found");
	        }
	        return jsonElement;
	    }
	    public static JsonElement getJson2(String Path) {
	        JsonParser jsonParser = new JsonParser();
	        JsonElement jsonElement=null;
	        try {
	            FileReader fileReader = new FileReader(Path);//Json2 filePath
	            jsonElement = jsonParser.parse(fileReader);
	        } catch (Exception e) {
	            System.out.println("File not found");
	        }
	        return jsonElement;
	    }
	    
	    public static JsonElement getJson3(String Path) {
	        JsonParser jsonParser = new JsonParser();
	        JsonElement jsonElement=null;
	        try {
	            FileReader fileReader = new FileReader(Path);//Json3 filePath
	            jsonElement = jsonParser.parse(fileReader);
	        } catch (Exception e) {
	            System.out.println("File not found");
	        }
	        return jsonElement;
	    }
	
	
   /* public static JsonElement getJson1() {
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement=null;
        try {
            FileReader fileReader = new FileReader("D:\\Santhosh\\sample2.json");//Json1 filePath
            jsonElement = jsonParser.parse(fileReader);
        } catch (Exception e) {
            System.out.println("File not found");
        }
        return jsonElement;
    }
    public static JsonElement getJson2() {
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement=null;
        try {
            FileReader fileReader = new FileReader("D:\\Santhosh\\sample5.json");//Json2 filePath
            jsonElement = jsonParser.parse(fileReader);
        } catch (Exception e) {
            System.out.println("File not found");
        }
        return jsonElement;
    }*/
} 