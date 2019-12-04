package com.example.retrof.atividade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.retrof.R;
import com.example.retrof.adapter.CommentsAdapter;
import com.example.retrof.bootstrap.BoostrapApi;
import com.example.retrof.representacao.Comments;
import com.example.retrof.representacao.Comments;
import com.example.retrof.resoucer.CommentsService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentsActivity extends AppCompatActivity {
    EditText postId;
    EditText txtUseId;
    EditText txtemail;
    EditText txtBody;
    ListView listView;
    ////////////////////////////////////////////////////
    CommentsService commentsService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
    }
    private void carregarDados(){
        /////////////////////////////////////////////////
        commentsService = BoostrapApi.getClient()
                .create(CommentsService.class);

        final Call<List<Comments>> get = commentsService.get();

        get.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response
                    <List<Comments>> response) {
                ////////////////lista de posts
                List<Comments> posts = response.body();
                //pegar lista
                listView = findViewById(R.id.listViewPost);
                //chamar adapter
                List<Comments> comments = null;
                CommentsAdapter adapter=new CommentsAdapter(getApplicationContext(),comments);
                //bind com a lista
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {

            }
        });
    }

    public void adicionar(View view) {
        carregarDados();

    }
}
