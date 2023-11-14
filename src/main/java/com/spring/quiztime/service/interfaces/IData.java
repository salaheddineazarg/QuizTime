package com.spring.quiztime.service.interfaces;

import java.util.List;
import java.util.Optional;

public interface IData<R,T,type> {

    List<R> getAllService();

    Optional<R> saveService(T type);

    boolean deleteService(type Id);

    Optional<R> updateService(T type,type Id);

   Optional<R> findByIdService(type Id);
}
