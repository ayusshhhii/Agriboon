package agriboon.example.myagriboonapp.Model;

public class UserAd {
       private String Name;
       private String Address;
       private String City;
       private String Code;
       private String Number;

    public UserAd() {
    }

    public UserAd(String name, String address, String city, String code, String number) {
        this.Name = name;
        this.Address = address;
        this.City = city;
        this.Code = code;
        this.Number = number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
}
