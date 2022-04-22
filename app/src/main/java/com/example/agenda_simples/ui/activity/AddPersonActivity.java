package com.example.agenda_simples.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.agenda_simples.DAO.AlunoDAO;
import com.example.agenda_simples.R;
import com.example.agenda_simples.model.Aluno;

public class AddPersonActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Adicionar Contato";
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;

    final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
        setTitle(TITLE_APPBAR);

        buscaDoscampos();

        botaoSalvarConfiguracao();
    }

    private void botaoSalvarConfiguracao() {
        Button botaoSalvar = findViewById(R.id.button_save);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Aluno aluno1 = criaContato();
                salvar(aluno1);
            }
        });
    }

    private void buscaDoscampos() {
        campoNome = findViewById(R.id.Name_Space);
        campoTelefone = findViewById(R.id.Telefone_Space);
        campoEmail = findViewById(R.id.Email_Space);
    }

    private void salvar(Aluno aluno1) {
        dao.salva(aluno1);

        finish();
    }

    @NonNull
    private Aluno criaContato() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        Aluno aluno1 = new Aluno(nome, telefone, email);
        return aluno1;
    }
}