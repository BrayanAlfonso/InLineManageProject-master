package model;

public class ProductoVo {
    //En esta clase pondremos los getters y setter como si fuera en bean en IntelliJIdea

private int id_product;
private String name_product;
private Float value_product;
private int id_category;



public ProductoVo() {
}



public ProductoVo(int id_product, String name_product, Float value_product, int id_category) {
    this.id_product = id_product;
    this.name_product = name_product;
    this.value_product = value_product;
    this.id_category = id_category;
}





public int getId_product() {
    return id_product;
}
public void setId_product(int id_product) {
    this.id_product = id_product;
}
public String getName_product() {
    return name_product;
}
public void setName_product(String name_product) {
    this.name_product = name_product;
}
public Float getValue_product() {
    return value_product;
}
public void setValue_product(Float value_product) {
    this.value_product = value_product;
}
public int getId_category() {
    return id_category;
}
public void setId_category(int id_category) {
    this.id_category = id_category;
}



}
