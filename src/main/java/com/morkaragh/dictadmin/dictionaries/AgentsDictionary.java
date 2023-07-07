package com.morkaragh.dictadmin.dictionaries;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentsDictionary {

    public List<Agent> getAgents() {

        return List.of(new Agent(1L, "Табаков Игорь Андреевич", "агентский договор 1004-501"),
                new Agent(2L, "Заболотный Юрий Иванович", "агентский договор 1004-502"),
                new Agent(3L, "Заболотная Татьяна Степановна", "агентский договор 1004-503"),
                new Agent(4L, "Водоканаловна Жанна Владимировна", "агентский договор 1004-504"),
                new Agent(5L, "Баранова Надежда Андреевна", "агентский договор 1004-505"));
    }

}
