package com.example.demo.testmodel;

import com.example.demo.Entities.Users;
import com.example.demo.Repository.UserRepository;

import java.util.*;

public class UserRepositoryStub implements UserRepository {

    private Map<Integer,Users> users=new HashMap<Integer, Users>();
    Iterable<Users> iterable = Arrays.asList();

    @Override
    public <S extends Users> S save(S s) {
        users.put(s.getId(),s);
        return null;
    }

    @Override
    public <S extends Users> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Users> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Users> findAll() {

        return iterable;
    }

    @Override
    public Iterable<Users> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Users users) {

    }

    @Override
    public void deleteAll(Iterable<? extends Users> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    public Map<Integer,Users> getUsers(){
        return users;
    }
}
