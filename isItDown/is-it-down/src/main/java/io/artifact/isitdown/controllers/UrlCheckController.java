package io.artifact.isitdown.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlCheckController {

    private final String SITE_UP = "Site is up and running";
    private final String SITE_DOWN = "Site is currently down";
    private final String ERROR = "There is an error. Check the url";

    @GetMapping("/check")
    public String getUrlStatusMessage(@RequestParam String url) {
        String message = SITE_UP;
        try {
            URL urlObj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            
            int responseCode =conn.getResponseCode() / 100;
            
            if(responseCode != 2 || responseCode !=3){ 
                message=SITE_DOWN;
            }
            else{
                message=SITE_UP;
            }

        } catch (MalformedURLException e) {
            message= ERROR;
        } catch (IOException e) {
            message= SITE_DOWN;
        }

        return message;
    }



}
