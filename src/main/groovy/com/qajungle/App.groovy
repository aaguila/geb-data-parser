package com.qajungle

import com.qajungle.parsers.GebTestParser

/**
 * Parser main class
 */
class App {

    /**
     * Parser main method
     *
     * @param project - args[0]
     * @param url - args[1]
     * @param jobId - args[1]
     */
    public static void main(String[] args){

        String url = args[0]

        GebTestParser parser = new GebTestParser()
        parser.parseGebXml(url)

    }

}
