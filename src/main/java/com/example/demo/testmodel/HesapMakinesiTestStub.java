package com.example.demo.testmodel;

import com.example.demo.Entities.Users;
import com.example.demo.Repository.UserRepository;
import com.example.demo.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.junit.Assert;
public class HesapMakinesiTestStub {
   private UserRepositoryStub userRepositoryStub=new UserRepositoryStub();
    private UserService userService;
    UserRepository userRepository;
    @Before
    public void setUp() throws Exception {
     userService=new UserService();
     userRepository=Mockito.mock(UserRepository.class);
    }

    @Test
    public void repotest(){

       // userService.GetUsers();
        boolean a=true;
        Iterable<Users> usersIterable=userRepositoryStub.findAll();
        if(usersIterable==null)
            a=false;
        Assert.assertTrue(a);
       // Mockito.verify(userRepository).findAll();
        // Assert.assertEquals(24,toplam);
    }

}
