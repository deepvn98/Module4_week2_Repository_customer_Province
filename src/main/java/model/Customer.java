package model;


import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;
    private String img;

    public Customer() {
    }

    public Customer(Long id, String name, Province province, String img) {
        this.id = id;
        this.name = name;
        this.province = province;
        this.img = img;
    }

    public Customer(String name, Province province, String img) {
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
