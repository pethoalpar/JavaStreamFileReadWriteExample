package com.pethoalpar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String fileName = "D:/out.txt";
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i<11; ++i){
            sb.append("line").append(i).append(System.lineSeparator());
        }
        try{
            Files.write(Paths.get(fileName), sb.toString().getBytes(), StandardOpenOption.DELETE_ON_CLOSE);
        } catch (IOException e){
            Logger.getGlobal().warning("File not found");
        }
        try(Stream<String> stream = Files.lines(Paths.get(fileName))){
            stream.forEach(System.out :: println);
        }catch (IOException e){
            Logger.getGlobal().warning("File not found");
        }
    }
}
