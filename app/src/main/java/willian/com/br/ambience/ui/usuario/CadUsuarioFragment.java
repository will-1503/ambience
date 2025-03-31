package willian.com.br.ambience.ui.usuario;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import willian.com.br.ambience.R;
import willian.com.br.ambience.model.Usuario;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadUsuarioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadUsuarioFragment extends Fragment implements View.OnClickListener {

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
    private EditText etIdade;
    private EditText etSenha;
    private Button btSalvar;


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
        this.etIdade = view.findViewById(R.id.etIdade);
        this.etSenha = view.findViewById((R.id.etSenha));
        this.btSalvar = view.findViewById(R.id.btSalvar);
        //definindo o listener do botão
        this.btSalvar.setOnClickListener(this);
      //RETORNO DA FUNÇÃO
        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btSalvar){
            //instancear meu objeto de negócio
            try {
                Usuario usuario = new Usuario();
                //pegar dados da tela e por no objeto
                usuario.setNome(this.etNome.getText().toString());
                usuario.setEmail(this.etEmail.getText().toString());
                int idade = Integer.parseInt(this.etIdade.getText().toString());
                usuario.setIdade(idade);
                usuario.setSenha(this.etSenha.getText().toString());
                //mensagem de sucesso
                Toast.makeText(view.getContext(), "Sucesso", Toast.LENGTH_LONG ).show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }
}

