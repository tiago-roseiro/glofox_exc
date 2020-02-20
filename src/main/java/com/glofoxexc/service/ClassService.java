package com.glofoxexc.service;


import com.glofoxexc.service.dto.ClassDTO;


public interface ClassService {

   void addClass(ClassDTO classDTO);

   ClassDTO getClass(Long id);
}
