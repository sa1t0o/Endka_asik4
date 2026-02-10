package com.example.as4.service;




import com.example.as4.model.dto.FootballerDTO;

import java.util.List;

public interface FootballerService {
    FootballerDTO create(FootballerDTO dto);
    FootballerDTO getById(Long id);
    List<FootballerDTO> getAll();
    FootballerDTO update(Long id, FootballerDTO dto);
    void delete(Long id);
}









