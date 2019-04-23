/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author DaniNoot
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)// super classe pai
@Table(name = "pessoa")
public class Pessoa implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O nome não pode ser nulo")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @NotBlank(message = "O nome não pode ser em branco")
    @Column(name = "nome", nullable = false, length = 50) 
    private String nome;
    @NotNull(message = "O CPF não pode ser nulo")
    @Length(max = 14, message = "O CPF não pode ter mais que {max} caracteres")
    @NotBlank(message = "O CPF não pode ser em branco")
    @Column(name = "cpf", nullable = false, length = 14)      
    @CPF(message = "O CPF deve ser válido")
    private String cpf;
    @NotNull(message = "O telefone não pode ser nulo")
    @Length(max = 16, message = "O telefone não pode ter mais que {max} caracteres")
    @NotBlank(message = "O telefone não pode ser em branco")
    @Column(name = "telefone", nullable = false, length = 16)    
    private String telefone;
    @Email(message = "O email deve ser válido")
    @NotNull(message = "O email não pode ser nulo")
    @Length(max = 50, message = "O email não pode ter mais que {max} caracteres")
    @NotBlank(message = "O email não pode ser em branco")
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    
    /*
     @OneToMany(mappedBy = "Pessoa", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Mensalidades> mensalidades = new ArrayList<>();
    */
    
    public Pessoa() {
    }

 
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", email=" + email + '}';
    }
    
    
}
