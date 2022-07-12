package ru.baradys.web_app.config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


@SpringBootApplication
public class MainClass {
    public static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        SpringApplication.run(MainClass.class, args);
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "wmic useraccount list full");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true){
            line = r.readLine();
            if (line == null){
                break;
            }
            else if (line.startsWith("Name")){
                result.add(line.split("=")[1]);
            }
        }
    }
}
