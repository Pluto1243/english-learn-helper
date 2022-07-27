package com.wj.boot;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootApplicationTests {

    @Test
    void contextLoads() throws Exception {

        String word = "1. test".replaceAll("[^A-Za-z]", "");

    }
}
