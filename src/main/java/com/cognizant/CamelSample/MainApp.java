package com.cognizant.CamelSample;

import org.apache.camel.main.Main;

/**
 * A Camel Application
 * 
 * sample app to listen on a specific folder, transfer files to another folder, or to copy, this is without the use of
 * 
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.addRouteBuilder(new MyRouteBuilder(args));
        main.run(args);
    }

}

