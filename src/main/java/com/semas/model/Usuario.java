package com.semas.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.semas.enums.Bairros;
import com.semas.enums.TipoBeneficio;

@Entity
public class Usuario {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    private String pasta;

    @NotEmpty(message = "O nome do usuário é obrigatório")
    @Size(max = 150, message = "O nome não pode conter mais de 150 caracteres")
    private String nome;

    @NotEmpty(message = "O telefone do usuário é obrigatório")
    private String telefone;

    @Enumerated(EnumType.STRING)
    private TipoBeneficio tipoBeneficio;

    @Enumerated(EnumType.STRING)
    private Bairros bairro;

    @Size(max = 100, message = "A observação não pode ter mais que 100 caracteres")
    private String observacao;
    
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoBeneficio getTipoBeneficio() {
        return tipoBeneficio;
    }

    public void setTipoBeneficio(TipoBeneficio tipoBeneficio) {
        this.tipoBeneficio = tipoBeneficio;
    }        

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    public boolean isCincoMil(){
        return TipoBeneficio.CINCOMIL.equals(this.tipoBeneficio);
    }

    public Bairros getBairro() {
        return bairro;
    }

    public void setBairro(Bairros bairro) {
        this.bairro = bairro;
    }

    public String getPasta() {
        return pasta;
    }

    public void setPasta(String pasta) {
        this.pasta = pasta;
    }
    
}