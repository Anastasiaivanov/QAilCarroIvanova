package com.ilcarro.qa11.test;

import org.testng.annotations.Test;

public class LinksTests extends TestBase{

    @Test
    public void getAndCheckAllLinksTest(){
        app.getHeader().getAllLinksFromHomePage();
        app.getHeader().checkBrokenLinksOnHomePage();
    }
}
