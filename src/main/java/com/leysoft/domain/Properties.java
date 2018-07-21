
package com.leysoft.domain;

import java.io.Serializable;

public class Properties implements Serializable {

    private static final long serialVersionUID = 1L;

    private String codigo;

    private String name;

    private String description;

    public Properties() {
    }

    public Properties(String codigo, String name, String description) {
        this.codigo = codigo;
        this.name = name;
        this.description = description;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
