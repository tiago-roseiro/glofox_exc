package com.glofoxexc.service;

import com.glofoxexc.domain.Class;
import com.glofoxexc.repository.ClassRepository;
import com.glofoxexc.service.dto.ClassDTO;
import com.glofoxexc.service.exception.ClassNotFoundException;
import com.glofoxexc.service.exception.DataIntegrityException;
import com.glofoxexc.service.exception.InvalidDatesException;
import com.glofoxexc.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Service
@Transactional
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassRepository classRepository;

    @Autowired
    Validator validator;


    @Override
    public void addClass(ClassDTO classDTO) {

        LocalDate startDate = classDTO.getStartDate();
        LocalDate endDate = classDTO.getEndDate();

        if (validator.validateClassDates(startDate, endDate)) {
            for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {

                if (existsClassForDate(date)) {

                    throw new DataIntegrityException("A class already exists for the date: " + date);

                } else {

                    Class newClass = new Class();
                    newClass.setName(classDTO.getName());
                    newClass.setStartDate(date);
                    newClass.setEndDate(date);
                    newClass.setCapacity(classDTO.getCapacity());
                    classRepository.save(newClass);

                }

            }

        } else {
            throw new InvalidDatesException("The input dates are invalid!");
        }


    }

    private boolean existsClassForDate(LocalDate date) {
        return classRepository.existsClassByStartDate(date);
    }

    @Override
    public ClassDTO getClass(Long id) {

        Class currentClass = classRepository.findClassById(id);

        if(currentClass == null){
            throw new ClassNotFoundException("Class not found!");
        }

        return new ClassDTO(currentClass.getName(),currentClass.getStartDate(),currentClass.getEndDate(),currentClass.getCapacity());

    }
}
