package willian.com.br.ambience.model;


import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Usuario {
    //atributos
    private String email;
    private String nome;
    private int idade;
    private String senha;


    //CONSTRUTOR - Inicializa os atributos para gerar Objeto Json
    public Usuario () throws Exception {
        this.setNome("");
        this.setEmail("");
        this.setIdade(0);
        this.setSenha("");
    }
    //CONSTRUTOR - inicializa atributos de um arquivo JSon
    public Usuario (JSONObject jp) {
        try {
            this.setEmail(jp.getString("email"));
            this.setNome(jp.getString("nome"));
            this.setIdade(jp.getInt("idade"));
            this.setSenha(jp.getString("senha"));
        } catch (Exception e) {
            Log.e("Usuario", Objects.requireNonNull(e.getMessage()));
        }
    }

    //Metodo retorna o objeto com dados no formato JSON
    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        try {
            json.put("email", this.email);
            json.put("nome", this.nome);
            json.put("idade", this.idade);
            json.put("senha", this.senha);

        } catch (JSONException e) {
            Log.e("Usuario", Objects.requireNonNull(e.getMessage()));
        }
        return json;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}


