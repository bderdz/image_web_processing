package pl.umcs.oop.imageweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RectangleController {
    private List<Rectangle> rectangles;

    public RectangleController() {
        this.rectangles = new ArrayList<>();
    }

    @GetMapping("/rectangle")
    public Rectangle getRectangle() {
        Rectangle rectangle = new Rectangle(10, 20, 100, 200, "blue");

        return rectangle;
    }

//    @GetMapping("/rectangle/add")
//    public void addRectangle() {
//        Rectangle rectangle = new Rectangle(10, 20, 100, 200, "blue");
//
//        rectangles.add(rectangle);
//    }

    @GetMapping("/rectangle/add")
    public void addRectangle(@RequestBody Rectangle rectangle) {
        rectangles.add(rectangle);
    }

    @GetMapping("/rectangle/getAll")
    public List<Rectangle> getRectangles() {
        return rectangles;
    }

    @GetMapping("/rectangle/get/{index}")
    public Rectangle getRectangle(@PathVariable int index) {
        if (index >= 0 && index < rectangles.size()) {
            return rectangles.get(index);
        } else {
            throw new IndexOutOfBoundsException("Bad index");
        }
    }

    @GetMapping("/rectangle/put/{index}")
    public Rectangle putRectangle(@PathVariable int index, @RequestBody Rectangle rectangle) {
        if (index >= 0 && index < rectangles.size()) {
            return rectangles.set(index, rectangle);
        } else {
            throw new IndexOutOfBoundsException("Bad index");
        }
    }

    @GetMapping("/rectangle/delete/{index}")
    public Rectangle deleteRectangle(@PathVariable int index) {
        if (index >= 0 && index < rectangles.size()) {
            return rectangles.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Bad index");
        }
    }

    @GetMapping("/rectangle/toSvg")
    public String toSvg() {
        StringBuilder svg = new StringBuilder();

        svg.append("<svg width=\"800\" height=\"600\" xmlns=\"http://www.w3.org/2000/svg\">");

        for (Rectangle rect : rectangles) {
            svg.append(String.format(
                    "<rect x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" fill=\"%s\" />",
                    rect.getX(),
                    rect.getY(),
                    rect.getWidth(),
                    rect.getHeight(),
                    rect.getColor()));
        }

        svg.append("</svg>");

        return svg.toString();
    }
}
