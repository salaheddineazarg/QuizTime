package com.spring.quiztime.service.interfaces;

import java.util.List;
import java.util.Optional;

public interface IData<Response,Request,type> {

    List<Response> getAllService();

    Optional<Response> saveService(Request t);

    boolean deleteService(type Id);

    Optional<Response> updateService(Request t,type Id);

   Optional<Response> findByIdService(type Id);
}
