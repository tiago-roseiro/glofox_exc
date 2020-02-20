package com.glofoxexc.repository;

import com.glofoxexc.domain.Class;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public interface ClassRepository extends CrudRepository<Class, Long> {

    Class findClassByStartDate(LocalDate date);

    Class findClassById(Long id);

    boolean existsClassByStartDate(LocalDate date);
}
