package com.rao.consumer;

import com.hazelcast.core.IAtomicLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

@SpringBootApplication
@EnableBinding(Sink.class)
public class ConsumerApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumerApplication.class);

	@Autowired
	CounterEvents counterEvents;

	private IAtomicLong numberOfEvents;

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void phoneQueueListner(PhoneData phoneData) {
		countingEvents();
		validatePhoneNumber(phoneData.getPhoneNumber());

		log.info("Received: " + phoneData);
		log.info("Received Events: " + numberOfEvents.incrementAndGet());
	}

	private void countingEvents() {
		log.debug("Total Number of received events ={}", counterEvents.counting());
	}

	private boolean validatePhoneNumber(String phoneNo) {

		PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
		try {
			PhoneNumber numberProto = phoneUtil.parse(phoneNo, "");
			if(phoneUtil.isValidNumber(numberProto)){
				return  true;
			}
		}
		catch(NumberParseException e) {
			System.err.println("NumberParseException was thrown: " + e.toString());
		}
		return false;
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