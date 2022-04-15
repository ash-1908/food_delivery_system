package com.cg.FDS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.FDS.dao.IAddressRepository;
import com.cg.FDS.exception.EmptyValuesException;
import com.cg.FDS.exception.address.AddressNotFoundException;
import com.cg.FDS.model.Address;

@Service
public class IAddressServiceImpl {

	@Autowired
	IAddressRepository addrRepo;

	public Address addAddress(Address adr) {
		if (adr.getAddressId() == null || adr.getAddressId().length() == 0)
			throw new EmptyValuesException("Address Id cannot be empty.");
		if (adr.getBuildingName() == null || adr.getBuildingName().length() == 0)
			throw new EmptyValuesException("Address building name cannot be empty.");
		if (adr.getPincode() == null || adr.getPincode().length() == 0)
			throw new EmptyValuesException("Address pincode cannot be empty.");

		addrRepo.save(adr);
		return adr;
	}

	public Address viewAddress(String adr_id) {
		if (adr_id == null || adr_id.length() == 0)
			throw new EmptyValuesException("Address Id cannot be empty.");
		if (!addrRepo.existsById(adr_id))
			throw new AddressNotFoundException("Address does not exist.");

		return addrRepo.findById(adr_id).get();
	}

	public Address updateAddress(Address adr) {
		if (adr.getAddressId() == null || adr.getAddressId().length() == 0)
			throw new EmptyValuesException("Address Id cannot be empty.");
		if (!addrRepo.existsById(adr.getAddressId()))
			throw new AddressNotFoundException("Address does not exist.");

		addrRepo.save(adr);
		return adr;
	}

	public Address removeAddress(String adr_id) {
		if (adr_id == null || adr_id.length() == 0)
			throw new EmptyValuesException("Address Id cannot be empty.");
		if (!addrRepo.existsById(adr_id))
			throw new AddressNotFoundException("Address does not exist.");

		Address adr = addrRepo.findById(adr_id).get();
		addrRepo.deleteById(adr_id);
		return adr;
	}
}
