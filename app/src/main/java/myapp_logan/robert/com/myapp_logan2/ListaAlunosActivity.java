package myapp_logan.robert.com.myapp_logan2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class ListaAlunosActivity extends ActionBarActivity {

    private final String TAG = "CADASTRO_ALUNO";//Apenas pro LOG no Logcat
    private final String ALUNOS_KEY = "LISTA";//Chave para o Map do Objeto Bundle

    private EditText colocarNome;
    private EditText colocarEmail;
    private Button botaoSalvar;
    private ListView listagemAlunos;

    private List<String> listaDeAlunos;

    private ArrayAdapter<String> adapter;

    private int adapterLayout = android.R.layout.simple_list_item_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        colocarNome = (EditText) findViewById(R.id.colocarNome);
        colocarEmail = (EditText) findViewById(R.id.colocarEmail);
        botaoSalvar = (Button) findViewById(R.id.botaoSalvar);
        listagemAlunos = (ListView) findViewById(R.id.listagemAlunos);

        listaDeAlunos = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, adapterLayout, listaDeAlunos);

        listagemAlunos.setAdapter(adapter);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaDeAlunos.add(colocarNome.getText().toString());
                colocarNome.setText("");
                listaDeAlunos.add(colocarEmail.getText().toString());
                colocarEmail.setText("");
                adapter.notifyDataSetChanged();
            }
        });
        if (savedInstanceState != null) {
            listaDeAlunos = savedInstanceState.
                    getStringArrayList("ALUNOS_KEY");

        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(ALUNOS_KEY, (ArrayList<String>) listaDeAlunos);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        listaDeAlunos = savedInstanceState.getStringArrayList(ALUNOS_KEY);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_alunos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
