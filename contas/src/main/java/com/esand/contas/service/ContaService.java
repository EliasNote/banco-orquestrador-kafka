package com.esand.contas.service;

import com.esand.contas.dto.ContaDto;
import com.esand.contas.entity.Conta;
import com.esand.contas.repository.ContaRepository;
import com.esand.contas.utils.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.esand.contas.utils.Map.*;

@Service
@RequiredArgsConstructor
public class ContaService {

    private final ContaRepository contaRepository;

    @Transactional
    public ContaDto cadastrar(ContaDto dto) {
        return toDto(contaRepository.save(toConta(dto)));
    }

    @Transactional(readOnly = true)
    public List<ContaDto> buscarTodas() {
        return contaRepository.findAll().stream().map(Map::toDto).toList();
    }
}
