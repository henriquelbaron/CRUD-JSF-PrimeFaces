package sc.senac.br.cadastropessoa.model;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import sc.senac.br.cadastropessoa.bean.util.FormatadorData;

@Entity
@Table(name = "user")
public class User implements IBaseModel, Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = " é Obrigatório!")
	@Column(name = "nome", nullable = false)
	private String nome;

	@NotEmpty(message = " é Obrigatório")
	@Email
	@Size(max = 50)
	@Column(name = "email", nullable = false)
	private String email;

	@NotEmpty(message = " é Obrigatório")
	@Column(name = "senha")
	private String senha;

	@Temporal(TemporalType.DATE)
	@Column(name = "nascimento", nullable = false)
	private Date nascimento;

	private String observacao;

	@Transient
	private String nascimentoFormatado;

	@ManyToOne
	@JoinColumn(name = "idProfession", nullable = false)
	private Profession profession;

	public Integer getIdade() {
		if (nascimento != null) {
			LocalDate data = Instant.ofEpochMilli(this.nascimento.getTime()).atZone(ZoneId.systemDefault())
					.toLocalDate();
			return Period.between(data, LocalDate.now()).getYears();
		}
		return null;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getNascimentoFormatado() {
		return FormatadorData.getFormatadorDataBrasil().format(nascimento);
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", nascimento="
				+ nascimento + ", observacao=" + observacao + "]";
	}

}
