package com.sterling.nip.inwards.request.object;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@XmlRootElement(name = "NESingleRequest")
@XmlAccessorType (XmlAccessType.FIELD)
public class NameEnquiryRequest {
	@Id
	@XmlElement(name = "SessionID")
	private String sessionId;
	
	@XmlElement(name = "AccountNumber")
	private String accountNumber;
	
	@XmlElement(name = "ChannelCode")
	private int channelCode;
	
	@XmlElement(name = "DestinationInstitutionCode")
	private String destinationInstitutionCode;
	
	

}
