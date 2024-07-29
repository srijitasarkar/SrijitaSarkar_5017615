// Image.java
interface Image {
    void display();
}

// RealImage.java
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("Loading image: " + filename);
    }


    public void display() {
        System.out.println("image: " + filename);
    }
}

// ProxyImage.java
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }


    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// ProxyPatternTest.java
class ProxyPatternTest {
    public static void main(String[] args) {
        // Create ProxyImage instances
        Image image1 = new ProxyImage("imageA.jpg");
        Image image2 = new ProxyImage("imageB.jpg");

        // Display images
        // The image will be loaded and displayed only when display is called for the first time.
        image1.display();
        System.out.println("");
        image1.display();
        System.out.println("");
        image2.display();
        System.out.println("");
        image2.display();
    }
}