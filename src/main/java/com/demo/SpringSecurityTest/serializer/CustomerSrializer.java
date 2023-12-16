package com.demo.SpringSecurityTest.serializer;

import com.demo.SpringSecurityTest.customerManagement.entities.Customer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CustomerSrializer extends StdSerializer<Customer> {

    public CustomerSrializer(Class<Customer> t) {
        super(t);
    }

    public CustomerSrializer() {
        this(null);
    }


    @Override
    public void serialize(Customer value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        Customer customer = Customer.builder().build();
        if(value!=null)
        {
            customer.setId_costumer(value.getId_costumer());
            customer.setEmail(value.getEmail());
            customer.setName(value.getName());
            customer.setPhone_number(value.getPhone_number());
            customer.setStatus(value.getStatus());
            customer.setRso(value.getRso());
            customer.setCreatedAt(value.getCreatedAt());
            customer.setModifiedAt(value.getModifiedAt());
            //customer.setBills(value.getBills());
            //customer.setPromess(value.getPromess());

        }
        gen.writeObject(customer);
    }
}
