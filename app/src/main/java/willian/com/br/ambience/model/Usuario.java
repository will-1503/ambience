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
    private String projeto;


    //CONSTRUTOR - Inicializa os atributos para gerar Objeto Json
    public Usuario () throws Exception {
        this.setNome("");
        this.setEmail("");
        this.setProtocolo(0);
        this.setSenha("");
        this.setProjeto("");
    }
    //CONSTRUTOR - inicializa atributos de um arquivo JSon
    public Usuario (JSONObject jp) {
        try {
            this.setEmail(jp.getString("email"));
            this.setNome(jp.getString("nome"));
            this.setProtocolo(jp.getInt("protocolo"));
            this.setSenha(jp.getString("senha"));
            this.setProjeto(jp.getString("projeto"));
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
            json.put("protocolo", this.protocolo);
            json.put("senha", this.senha);
            json.put("projeto", this.projeto);
        } catch (JSONException e) {
            Log.e("Usuario", Objects.requireNonNull(e.getMessage()));
        }
        return json;
    }

    public String getProjeto() {
        return projeto;
    }

    public void setProjeto(String projeto) {
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


