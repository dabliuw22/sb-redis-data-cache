
package com.leysoft.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Util {

    private Util() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);

    public static <T extends Serializable> String encodeBase64(T object) {
        String stringObject = null;
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream so = new ObjectOutputStream(bo);
            so.writeObject(object);
            stringObject = Base64.getEncoder().encodeToString(bo.toByteArray());
        } catch (IOException | NullPointerException e) {
            LOGGER.error("Error {}", e.getMessage());
        }
        return stringObject;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T decodeBase64(String stringObject) {
        T object = null;
        try {
            byte[] objectData = Base64.getDecoder().decode(stringObject);
            ObjectInputStream si = new ObjectInputStream(new ByteArrayInputStream(objectData));
            object = (T) si.readObject();
        } catch (IOException | ClassNotFoundException | NullPointerException e) {
            LOGGER.error("Error {}", e.getMessage());
        }
        return object;
    }
}
