package willian.com.br.ambience.ui.usuario;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

import willian.com.br.ambience.R;
import willian.com.br.ambience.model.Usuario;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadUsuarioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadUsuarioFragment extends Fragment implements View.OnClickListener, Response.ErrorListener, Response.Listener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    private EditText etNome;
    private EditText etEmail;
    private EditText etProtocolo;
    private EditText etSenha;
    private Spinner spProjeto;
    private Button btSalvar;
    //volley
    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectReq;


    public CadUsuarioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadUsuarioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CadUsuarioFragment newInstance(String param1, String param2) {
        CadUsuarioFragment fragment = new CadUsuarioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_cad_usuario, container, false);
        //Binding
        this.etNome = view.findViewById(R.id.etNome);
        this.etEmail = view.findViewById(R.id.etEmail);
        this.etProtocolo = view.findViewById(R.id.etProtocolo);
        this.etSenha = view.findViewById((R.id.etSenha));
        this.btSalvar = view.findViewById(R.id.btSalvar);
        this.spProjeto = view.findViewById(R.id.spProjeto);
        //definindo o listener do botão
        this.btSalvar.setOnClickListener(this);
        //instanciando a fila de requests - caso o objeto seja o view
        this.requestQueue = Volley.newRequestQueue(view.getContext());
        //inicializando a fila de requests do SO
        this.requestQueue.start();
        //RETORNO DA FUNÇÃO
        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btSalvar) {
            //instancear meu objeto de negócio
            try {
                Usuario usuario = new Usuario();
                //pegar dados da tela e por no objeto
                usuario.setNome(this.etNome.getText().toString());
                usuario.setEmail(this.etEmail.getText().toString());
                int protocolo = Integer.parseInt(this.etProtocolo.getText().toString());
                usuario.setProtocolo(protocolo);
                usuario.setSenha(this.etSenha.getText().toString());
                usuario.setProjeto(this.spProjeto.getItemAtPosition(this.spProjeto.getSelectedItemPosition()).toString());
                //REQUEST VOLLEY AQUI !!!!!!!
                jsonObjectReq = new JsonObjectRequest(
                        Request.Method.POST,
                        "http://10.0.2.2:8080/seg/cadusuario.php",
                        usuario.toJsonObject(), this, this);
                requestQueue.add(jsonObjectReq);

                //mensagem de sucesso
                Toast.makeText(view.getContext(), "Sucesso", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }


    @Override
    public void onResponse(Object response) {
        try {
//instanciando objeto para manejar o JSON que recebemos
            JSONObject jason = new JSONObject(response.toString());
            //context e text são para a mensagem na tela o Toast
            Context context = view.getContext();
//pegando mensagem que veio do json
            CharSequence mensagem = jason.getString("message");
//duração da mensagem na tela
            int duration = Toast.LENGTH_SHORT;
            //verificando se salvou sem erro para limpar campos da tela
            if (jason.getBoolean("success")) {
//limpar campos da tela
                this.etNome.setText("");
                this.etSenha.setText("");
                this.etProtocolo.setText("");
                this.etEmail.setText("");
                this.spProjeto.setSelection(0);
            }
//mostrando a mensagem que veio do JSON
            Toast toast = Toast.makeText(context, mensagem, duration);
            toast.show();

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Snackbar mensagem = Snackbar.make(view,
                "Ops! Houve um problema ao realizar o cadastro: " +
                        error.toString(), Snackbar.LENGTH_LONG);
        mensagem.show();
    }
}


