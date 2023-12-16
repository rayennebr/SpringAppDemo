package com.demo.SpringSecurityTest.serializer;

import com.demo.SpringSecurityTest.billManagement.entities.Bill;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BillSerializer extends StdSerializer<List<Bill>> {


    protected BillSerializer(Class<List<Bill>> t) {
        super(t);
    }

    protected BillSerializer() {
        this(null);
    }

    @Override
    public void serialize(List<Bill> values, JsonGenerator gen, SerializerProvider provider) throws IOException {
        List<Bill>bills=new ArrayList<>();
        if(!values.isEmpty())
        {
            for(Bill value:values)
            {
                Bill bill= Bill.builder().build();
                if(value !=null)
                {
                    bill.setId_bill(value.getId_bill());
                    bill.setAmount(value.getAmount());
                    bill.setPayment_date(value.getPayment_date());
                    bill.setStatus(value.getStatus());
                    bill.setPay(value.isPay());
                    bill.setBilling_reminder(value.isBilling_reminder());
                    bill.setCreatedAt(value.getCreatedAt());
                    bill.setModifiedAt(value.getModifiedAt());
                    bills.add(bill);
                }
            }
        }
        gen.writeObject(bills);

    }
}
