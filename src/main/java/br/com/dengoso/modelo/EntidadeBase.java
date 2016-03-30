package br.com.dengoso.modelo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class EntidadeBase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Long id;  

	public Long getId() {  
		return id;  
	}  

	@Override  
	public int hashCode() {  
		int hash = 0;  
		hash += (this.getId() != null ? this.getId().hashCode() : 0);  

		return hash;  
	}  

	@Override  
	public boolean equals(Object object) {  
		if (this == object) {  
			return true;  
		}
		if (object == null) {  
			return false;  
		}
		if (getClass() != object.getClass()) {  
			return false;  
		}

		EntidadeBase other = (EntidadeBase) object;  
		if (this.getId() != null && this.id.equals(other.id)) {  
			return true;  
		}  
		return false;  
	}  

	@Override  
	public String toString() {  
		return this.getClass().getName() + " [ID=" + id + "]";  
	}  
}
