package ungp.sampleng.backend.util.pageable;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import ungp.sampleng.backend.entity.Logradouro;

@XmlRootElement
public class PageData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Logradouro> content;
	private Integer number;
	private Integer numberOfElements;
	private Long totalElements;
	private Integer size;
	private Integer totalPages;
	private String sort;
	
	public PageData() {
		
	}
	

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getNumberOfElements() {
		return numberOfElements;
	}

	public void setNumberOfElements(Integer numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	public Long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}


	public List<Logradouro> getContent() {
		return content;
	}


	public void setContent(List<Logradouro> content) {
		this.content = content;
	}

	
}
