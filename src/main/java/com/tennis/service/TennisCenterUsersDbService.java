package com.tennis.service;

import com.tennis.domain.TennisCenterUsers;
import com.tennis.repository.TennisCenterUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TennisCenterUsersDbService {
    @Autowired
    private TennisCenterUsersRepository tennisCenterUsersRepository;

    public List<TennisCenterUsers> getAllTennisCenterUsers() {
        return tennisCenterUsersRepository.findAll();
    }

    public Optional<TennisCenterUsers> getTennisCenterUserById(final Long id) {
        return tennisCenterUsersRepository.findById(id);
    }

    public TennisCenterUsers saveTennisCenterUser(final TennisCenterUsers tennisCenterUsers) {
        return tennisCenterUsersRepository.save(tennisCenterUsers);
    }

    public void deleteTennisCenterUserById(final Long id) {
        tennisCenterUsersRepository.deleteById(id);
    }
}
