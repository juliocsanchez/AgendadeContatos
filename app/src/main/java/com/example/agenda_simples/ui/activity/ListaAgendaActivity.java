package com.example.agenda_simples.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda_simples.DAO.AlunoDAO;
import com.example.agenda_simples.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ListaAgendaActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR_FIRST_ACTIVITY = "Lista";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_agenda);
        setTitle(TITLE_APPBAR_FIRST_ACTIVITY);

        configurarFABNovoContato();
    }

    private void configurarFABNovoContato() {
        FloatingActionButton botao = findViewById(R.id.FAB_nova_pessoa);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListaAgendaActivity.this,
                        AddPersonActivity.class));
            }
        });
    }

    protected void onResume(){
        super.onResume();

        AlunoDAO dao = new AlunoDAO();

        ListView ListaDePessoas = findViewById(R.id.agenda_listview);
        ListaDePessoas.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                dao.all()));
    }

}


