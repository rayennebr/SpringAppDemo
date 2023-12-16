package com.demo.SpringSecurityTest.serializer;

import com.demo.SpringSecurityTest.promessManagement.entity.Promess;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PromessSerializer extends StdSerializer<List<Promess>> {


    protected PromessSerializer(Class<List<Promess>> t) {
        super(t);
    }

    protected PromessSerializer() {
        this(null);
    }

    @Override
    public void serialize(List<Promess> values, JsonGenerator gen, SerializerProvider provider) throws IOException {
        List<Promess>promesses=new ArrayList<>();
        if(!promesses.isEmpty())
        {
            for (Promess value:values)
            {
                Promess promess= Promess.builder().build();
                if(value!=null)
                {
                    promess.setIdPromess(value.getIdPromess());
                    promess.setPromessAmount(value.getPromessAmount());
                    promess.setPromessDate(value.getPromessDate());
                    promess.setStatus(value.getStatus());
                    promess.setCreatedDate(value.getCreatedDate());
                    promess.setModifiedDate(value.getModifiedDate());
                }
                promesses.add(promess);
            }
        }
        gen.writeObject(promesses);
    }
}
