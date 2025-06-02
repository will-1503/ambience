package willian.com.br.ambience.model;


import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Usuario {
    //atributos
    private String email;
    private String nome;
    private int protocolo;
    private String senha;
    private int projeto;


    //CONSTRUTOR - Inicializa os atributos para gerar Objeto Json
    public Usuario () throws Exception {
        this.setNome("");
        this.setEmail("");
        this.setProtocolo(0);
        this.setSenha("");
        this.setProjeto(1);
    }
    //CONSTRUTOR - inicializa atributos de um arquivo JSon
    public Usuario (JSONObject jp) {
        try {
            this.setEmail(jp.getString("idEmail"));
            this.setNome(jp.getString("idNome"));
            this.setProtocolo(jp.getInt("idProtocoo"));
            this.setProjeto(jp.getInt("idProjeto"));
        } catch (Exception e) {
            Log.e("Usuario", Objects.requireNonNull(e.getMessage()));
        }
    }

    //Metodo retorna o objeto com dados no formato JSON
    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        try {
            json.put("idEmail", this.email);
            json.put("idNome", this.nome);
            json.put("idProtocoo", this.protocolo);
            json.put("idSenha", this.senha);
            json.put("idProjeto", this.projeto);
        } catch (JSONException e) {
            Log.e("Usuario", Objects.requireNonNull(e.getMessage()));
        }
        return json;
    }

    public int getProjeto() {
        return projeto;
    }

    public void setProjeto(int projeto) {
        this.projeto = projeto;
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

    public int getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(int protocolo) {
        this.protocolo = protocolo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}


