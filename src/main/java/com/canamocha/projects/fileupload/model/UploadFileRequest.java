//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.12.10 a las 09:58:38 AM CET 
//

package com.canamocha.projects.fileupload.model;

import org.hibernate.validator.constraints.NotEmpty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para anonymous complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="inputText" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="file"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}base64Binary"&gt;
 *               &lt;maxLength value="1000000000"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "inputText", "file" })
@XmlRootElement(name = "uploadFileRequest")
public class UploadFileRequest {

	@XmlElement(required = true)
	@NotBlank
	protected String inputText;
	@XmlElement(required = true)
	@NotNull
	@NotEmpty
	protected byte[] file;

	/**
	 * Obtiene el valor de la propiedad inputText.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getInputText() {
		return inputText;
	}

	/**
	 * Define el valor de la propiedad inputText.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setInputText(String value) {
		this.inputText = value;
	}

	/**
	 * Obtiene el valor de la propiedad file.
	 * 
	 * @return possible object is byte[]
	 */
	public byte[] getFile() {
		return file;
	}

	/**
	 * Define el valor de la propiedad file.
	 * 
	 * @param value allowed object is byte[]
	 */
	public void setFile(byte[] value) {
		this.file = value;
	}

}
