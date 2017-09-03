import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Optional;

public class GrayScaleFilter implements ImageFilter {


  @Override
  public Optional<BufferedImage> processImage(BufferedImage input) {

    Optional<BufferedImage> imageWorkingCopy = ImageProcessor.deepCopy(input);
    imageWorkingCopy.ifPresent(image ->
    {
      for (int h = 0; h < image.getHeight(); ++h) {
        for (int w = 0; w < image.getWidth(); ++w) {
          Color c = new Color(image.getRGB(w, h));
          int red = c.getRed();
          image.setRGB(w, h, new Color(red, red, red).getRGB());
        }
      }
    });

    return imageWorkingCopy;
  }
}