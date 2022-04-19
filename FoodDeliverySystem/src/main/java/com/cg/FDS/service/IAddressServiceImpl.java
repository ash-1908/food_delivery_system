package com.cg.FDS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.FDS.dao.IAddressRepository;
import com.cg.FDS.exception.EmptyValuesException;
import com.cg.FDS.model.Address;

@Service
public class IAddressServiceImpl {

	@Autowired
	IAddressRepository addrRepo;

	public Address addAddress(Address adr) {
		if (adr.getBuildingName() == null || adr.getBuildingName().length() == 0)
			throw new EmptyValuesException("Building name in address cannot be empty.");
		if (adr.getPincode() == null || adr.getPincode().length() == 0)
			throw new EmptyValuesException("Pincode in address cannot be empty.");
		addrRepo.save(adr);
		return adr;
	}

	public Address getAddress(String adr_id) {
		if (addrRepo.existsById(adr_id))
			return addrRepo.findById(adr_id).get();
		return null;
	}

	public Address updateAddress(Address adr) {
		if (addrRepo.existsById(adr.getAddressId())) {
			addrRepo.save(adr);
			return adr;
		}
		return null;
	}

	public Address deleteAddress(String adr_id) {
		if (!addrRepo.existsById(adr_id))
			throw new EmptyValuesException("Address does not exists");
		Address adr = addrRepo.findById(adr_id).get();
		addrRepo.deleteById(adr_id);
		return adr;
	}
}
