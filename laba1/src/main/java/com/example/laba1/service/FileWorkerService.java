package com.example.laba1.service;

import com.example.laba1.parametres.entityParametres;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class FileWorkerService {
    public void write(String path, ArrayList<entityParametres> list) {
        try(FileWriter writer = new FileWriter(path,false)) {
            list.forEach((element)-> {
                        try {
                            writer.write(element.getPosition() + " " + element.getNewValue() + "\n");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
            );
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void write(String path, entityParametres parametres) {
        try(FileWriter writer = new FileWriter(path, true)) {
            writer.write(parametres.getPosition() + " " + parametres.getNewValue() + "\n");
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String read(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String buffer;
            String[] array = new String[2];
            BufferedReader reader = new BufferedReader(new FileReader(path));
            for(int i = 1; (buffer = reader.readLine()) != null; i++) {
                array = buffer.split(" ");
                stringBuilder.append("(" + i + ")Pos: " + array[0] + ", Val: " + array[1] + "; ");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public void read(String path, ArrayList<entityParametres> list) {
        try {
            String buffer;
            String[] array = new String[2];
            BufferedReader reader = new BufferedReader(new FileReader((path)));
            while((buffer = reader.readLine()) != null) {
                array = buffer.split(" ");
                int position = Integer.parseInt(array[0]);
                long newValue = Integer.parseInt(array[1]);
                list.add(new entityParametres(position, newValue));
            }
        } catch(IOException ex) {
            ex.printStackTrace();
            }
    }

    public void clearFile(String path) {
        try(FileWriter writer = new FileWriter(path, false)) {
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
