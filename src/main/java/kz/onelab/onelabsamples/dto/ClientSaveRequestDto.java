package kz.onelab.onelabsamples.dto;

public class ClientSaveRequestDto {

    private String name;

    public ClientSaveRequestDto() {
    }

    public ClientSaveRequestDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
