package com.rao.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class ConsumerApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void phoneQueueListner(PhoneData phoneData) {
		log.info("Received: " + phoneData);
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