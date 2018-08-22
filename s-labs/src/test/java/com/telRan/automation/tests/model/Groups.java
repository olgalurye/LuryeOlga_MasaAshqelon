package com.telRan.automation.tests.model;

public class Groups {
    private  String name;
    private  String header;
    private  String footer;

    public Groups withName(String name) {
        this.name = name;
        return this;
    }

    public Groups withHeader(String header) {
        this.header = header;
        return this;
    }

    public Groups withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }
}
