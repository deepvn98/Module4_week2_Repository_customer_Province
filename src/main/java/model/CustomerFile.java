package model;

import org.springframework.web.multipart.MultipartFile;

public class CustomerFile {
    private Long id;
    private String name;
    private Province province;
    private MultipartFile img;

    public CustomerFile() {
    }


    public CustomerFile(String name) {
        this.name = name;
    }

    public CustomerFile(Long id, String name, Province province, MultipartFile img) {
        this.id = id;
        this.name = name;
        this.province = province;
        this.img = img;
    }

    public CustomerFile(String name, Province province, MultipartFile img) {
        this.name = name;
        this.province = province;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }
}
