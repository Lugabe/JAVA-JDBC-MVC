package javaVirtualRepository.modelo;

public class Produto {

	private Integer id;
	private String name;
	private String description;

	public Produto(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Produto(String name, String description, Integer id) {
		this.name = name;
		this.description = description;
		this.id = id;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return String.format("O produto é : %d, %s, %s", this.id, this.name, this.description);
	}

}
