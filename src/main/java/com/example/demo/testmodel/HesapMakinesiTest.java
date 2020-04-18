package com.example.demo.testmodel;

import com.example.demo.API.TestController;
import com.example.demo.API.UserController;
import com.example.demo.Entities.Users;
import com.example.demo.Repository.UserRepository;
import com.example.demo.services.UserService;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import junitparams.JUnitParamsRunner;

//@RunWith(Parameterized.class) //Parametreler ile beraber çalışması gerektiğini söylüyoruz.Yoksa hata alır.Tüm Methodlar için çalıştırır.
@RunWith(JUnitParamsRunner.class)
public class HesapMakinesiTest {
    @InjectMocks
    private UserService userServices1;
    @Mock
    private UserRepository userRepository1;

    TestController testController;
    UserController userController;
    UserRepository userRepository;
    UserService userService;
    @Before
    public void setUp() throws Exception {
         testController=new TestController();
         userService=new UserService();
         userRepository= Mockito.mock(UserRepository.class);
         userService.setUserRepository(userRepository);
    }

    /*
    En Üst Classta @RunWith(JUnitRunner.class) varsa Mock nesnesini setUp içinde Oluşturmaya gerek kalmaz..
    @Mock
    private UserRepository userrepository;  // diyerek oluşturabiliriz.

    UserServices 'e user repository'i constructor olarak vermek için ise @InjectMocks
    @InjectMock
    private UserServices userServices; // yazmalıyız

     */

   // @Parameterized.Parameters
  //  public static Collection<Object[]> data(){
   //     return Arrays.asList(new Object[][]{
    //            {8,2,16}, {6,2,12},{10,2,20}, //Sırasıyla eni,boyu.toplamMetreKare Şeklinde
   //     });
  //  }  //@RunWith(Parameterized.class) parametresini yazdıktan sonra bu methodda listeyi oluşturuyoruz.

//    private int eni;
 //   private int boyu;
 //   private int toplamMetreKare;

  //  public HesapMakinesiTest(int eni, int boyu, int toplamMetreKare) {
   //     this.eni = eni;
   //     this.boyu = boyu;
   //     this.toplamMetreKare = toplamMetreKare;
  //  } ////@RunWith(Parameterized.class) parametresini yazdıktan ve Listeyi belirledikten sonra constructor methodda değişkenleri belirliyoruz

    @Test
    @Parameters({
            "1, 2, 2",
            "-10, 30, -300",
            "15, -5, -75",
            "-5, -10, 50" })
    public void testMetreHesaplama(int eni,int boyu,int toplamMetreKare) throws Exception{
        Assert.assertEquals(toplamMetreKare,testController.metreKareHesapla(eni,boyu));
    }

    @Test
    @Ignore
    public void testet(){
        int sayi1=5;
        int sayi2=19;

        int toplam= testController.testEt(sayi1,sayi2);

        Assert.assertEquals(24,toplam);
    }

    @Test
    public void repotest(){

        List<Users> uesrs= userService.GetUsers();
       // Mockito.verify(userRepository).save(Mockito.any(Users.class)); veri eklenmesi için kullanılır.
       Mockito.verify(userRepository).findAll();
       // Assert.assertEquals(24,toplam);
    }
}
