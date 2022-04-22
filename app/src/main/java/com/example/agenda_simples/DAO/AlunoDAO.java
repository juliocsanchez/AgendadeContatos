package com.example.agenda_simples.DAO;

import com.example.agenda_simples.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();

    public void salva(Aluno aluno) {

        alunos.add(aluno);

    }

    public List<Aluno> all() {
        return new ArrayList<>(alunos);
    }
}
