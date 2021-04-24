package com.example.laba1.threads;

import com.example.laba1.parametres.entityParametres;
import com.example.laba1.service.FileWorkerService;

import java.util.ArrayList;

public class FileWriteRunner implements Runnable {
    private String path;
    private ArrayList<entityParametres> list;

    public FileWriteRunner(String path, ArrayList<entityParametres> list) {
        this.path = path;
        this.list = list;
    }

    @Override
    public void run() {
        FileWorkerService fileWorker = new FileWorkerService();
        fileWorker.write(path, list);
    }
}
