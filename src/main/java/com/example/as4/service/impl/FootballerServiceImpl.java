package com.example.as4.service.impl;

import com.example.as4.model.dto.FootballerDTO;
import com.example.as4.model.entity.Footballer;
import com.example.as4.repository.FootballerRepository;
import com.example.as4.service.FootballerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FootballerServiceImpl implements FootballerService {
    private final FootballerRepository footballerRepository;
@Autowired
    public FootballerServiceImpl(FootballerRepository footballerRepository){
        this.footballerRepository = footballerRepository;
    }
    @Override
    public FootballerDTO create(FootballerDTO dto) {
        Footballer footballer = Footballer.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getSurName())
                .age(dto.getAge())
                .position(dto.getPosition())
                .club(dto.getClub())
                .marketValue(dto.getMarketValue())
                .build();

        footballer = footballerRepository.save(footballer);
        return mapToDTO(footballer);
    }
    @Override
    public FootballerDTO getById(Long id) {
        Footballer footballer = footballerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapToDTO(footballer);
    }



    @Override
    public List<FootballerDTO> getAll() {
        return footballerRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
    @Override
    public FootballerDTO update(Long id, FootballerDTO dto) {
        Footballer footballer = footballerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Footballer not found with id: " + id));

        footballer.setFirstName(dto.getFirstName());
        footballer.setLastName(dto.getSurName());
        footballer.setAge(dto.getAge());
        footballer.setPosition(dto.getPosition());
        footballer.setClub(dto.getClub());
        footballer.setMarketValue(dto.getMarketValue());

        Footballer updated = footballerRepository.save(footballer);
        return mapToDTO(updated);
    }

    @Override
    public void delete(Long id) {
        Footballer footballer = footballerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Footballer not found with id: " + id));
        footballerRepository.delete(footballer);
    }
    private FootballerDTO mapToDTO(Footballer footballer) {
        return FootballerDTO.builder()
                .id(footballer.getId())
                .firstName(footballer.getFirstName())
                .surName(footballer.getLastName())
                .age(footballer.getAge())
                .position(footballer.getPosition())
                .club(footballer.getClub())
                .marketValue(footballer.getMarketValue())
                .build();
    }
}















