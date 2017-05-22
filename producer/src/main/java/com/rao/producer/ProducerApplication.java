package com.rao.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.util.Random;

@SpringBootApplication
@EnableBinding(Source.class)
public class ProducerApplication {

	private static final Logger log = LoggerFactory.getLogger(ProducerApplication.class);

	@Bean
	@InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "5000", maxMessagesPerPoll = "5"))
	public MessageSource<PhoneData> createMessageSource() {
		//TODO
		//Set random id and phone number
		return () -> new GenericMessage<PhoneData>( new PhoneData( new Random().nextLong() , "+4412346789"));
	}

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}


}

class PhoneData {
	private long phoneId;
	private String phoneNumber;

	public PhoneData() {
	}

	public PhoneData(long phoneId, String phoneNumber) {
		super();
		this.phoneId = phoneId;
		this.phoneNumber = phoneNumber;
	}

	public long getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(long phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "PhoneData [phoneId=" + phoneId + ", phoneNumber=" + phoneNumber + "]";
	}
}