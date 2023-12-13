package demo.demoGraphqlResolver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema="gql_demo", name="Product_Blueprint")
public class ProductBlueprint {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long fileId;

private String fileName;

private String fileSize;

public Long getFileId() {
	return fileId;
}

public void setFileId(Long fileId) {
	this.fileId = fileId;
}

public String getFileName() {
	return fileName;
}

public void setFileName(String fileName) {
	this.fileName = fileName;
}

public String getFileSize() {
	return fileSize;
}

public void setFileSize(String fileSize) {
	this.fileSize = fileSize;
}

}
