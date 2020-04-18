package com.example.demo.testmodel;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


//Bu iki kütüphane ile Assertj test yazarız assertThat dışında ifadeleri koyarız içerisinde izin vermez.
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HamcrestTest {

    List<String> sehirler=new ArrayList<>(Arrays.asList("İstanbul","Ankara","Sakarya","Trabzon"));
    @Test
    public void testTemelEslestirmeler() throws Exception{
        String text1="fatih";
       // assertThat(text1,is(equalTo("fatih"))); // test Assert'ini daha anlaşılır olması için hamcrest kullanırız.
        //assertThat(text1,is(nullValue()));
        // assertThat(text1,containsString("fat"));
        //  assertThat(text1,anyOf(containsString("fat"),containsString("ih"))); // text1 içerisinde fat veya ih var mı kontrol eder
        //Hamcrest
    }

    @Test
    public void assertJTest() throws Exception{
        String text1="fatih";

        assertThat(text1)
                .describedAs("hata mesajı için açıklama ekledik")
                .isEqualTo("fatih")
                .startsWith("fat")
                .endsWith("h")
                .contains("tisdf")
                .isNotEmpty();//AssertJ
    }

    @Test
    public void testSehirList() throws Exception{
        assertThat(sehirler)
                .describedAs("duplicate yapan il var")
                .contains("Ankara")
                .doesNotContain("Bursa")
                .doesNotHaveDuplicates();
    }

}
