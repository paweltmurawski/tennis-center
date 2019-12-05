package com.tennis.repository;

import com.tennis.domain.TennisCenterUsers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface TennisCenterUsersRepository extends CrudRepository<TennisCenterUsers, Long> {
    @Override
    List<TennisCenterUsers> findAll();

    @Override
    Optional<TennisCenterUsers> findById(Long id);

    @Override
    TennisCenterUsers save(TennisCenterUsers tennisCenterUsers);

    @Override
    void deleteById(Long id);
}
