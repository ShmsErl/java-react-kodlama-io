package com.example.javareactkamp.mapper;

import org.modelmapper.ModelMapper;

public interface MapperService {

    ModelMapper forRequest();
    ModelMapper forResponse();

}
