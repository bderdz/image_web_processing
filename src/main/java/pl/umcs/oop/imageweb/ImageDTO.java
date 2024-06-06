package pl.umcs.oop.imageweb;

public class ImageDTO {
    private String base64Image;
    private int brightness;

    public ImageDTO(String base64Image, int brightness) {
        this.base64Image = base64Image;
        this.brightness = brightness;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

}