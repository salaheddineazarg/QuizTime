package com.spring.quiztime.service.interfaces;

import java.util.List;
import java.util.Optional;

public interface IData<T,type> {

    List<T> getAllService();

    Optional<T> saveService(T type);

    boolean deleteService(type Id);

    Optional<T> updateService(T type,type Id);

   Optional<T> findByIdService(type Id);
}
