package com.example.laba1.service;

import com.example.laba1.parametres.entityParametres;
import com.example.laba1.threads.FileReadRunner;
import com.example.laba1.threads.FileWriteRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SortDatabaseService {
    public void sortDatabase(String path) {
        try {
            ArrayList<entityParametres> list = new ArrayList<>();
            Runnable FileReadRunner = ()-> {
                FileWorkerService fileWorker = new FileWorkerService();
                fileWorker.read(path, list);
            };
            Thread FileReadThread = new Thread(FileReadRunner);
            FileReadThread.start();
            FileReadThread.join();
            ArrayList<entityParametres> sortedList = list.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
            Runnable FileWriteRunner = ()-> {
                FileWorkerService fileWorker = new FileWorkerService();
                fileWorker.write(path, sortedList);
            };
            Thread FileWriteThread = new Thread(FileWriteRunner);
            FileWriteThread.start();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
