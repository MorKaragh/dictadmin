package com.morkaragh.dictadmin.dictionaries;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentsDictionary {

    public List<Pair<Long, String>> getAgents() {

        return List.of(Pair.of(1L, "Табаков Игорь Андреевич"),
                Pair.of(2L, "Заболотный Юрий Иванович"),
                Pair.of(3L, "Водоканаловна Жанна Владимировна"),
                Pair.of(4L, "Баранова Надежда Андреевна"));
    }

}
