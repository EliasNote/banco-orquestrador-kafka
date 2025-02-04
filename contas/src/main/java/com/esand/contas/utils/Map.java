package com.esand.contas.utils;

import com.esand.contas.dto.ContaDto;
import com.esand.contas.entity.Conta;

public class Map {

    public static Conta toConta(ContaDto dto) {
        return Conta.builder()
                .usuarioId(dto.usuarioId())
                .saldo(dto.saldo())
                .tipo(dto.tipo())
                .build();
    }

    public static ContaDto toDto(Conta conta) {
        return ContaDto.builder()
                .usuarioId(conta.getUsuarioId())
                .saldo(conta.getSaldo())
                .tipo(conta.getTipo())
                .build();
    }
}
