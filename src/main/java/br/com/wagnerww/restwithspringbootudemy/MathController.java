package br.com.wagnerww.restwithspringbootudemy;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    // private static final String template = "Hello %s!";
//    @RequestMapping("/greeting")
//    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//        new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {

        if (!isNumeric(numberOne) || !isNumeric((numberTwo))) {
            throw new UnsupportedOperationException("Please set a numeric value");
        }

        Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
        return sum;
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtration(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric((numberTwo))) {
            throw new UnsupportedOperationException("Please set a numeric value");
        }

        Double sub = convertToDouble(numberOne) - convertToDouble(numberTwo);

        return sub;
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric((numberTwo))) {
            throw new UnsupportedOperationException("Please set a numeric value");
        }

        Double mult = convertToDouble(numberOne) * convertToDouble(numberTwo);

        return mult;
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric((numberTwo))) {
            throw new UnsupportedOperationException("Please set a numeric value");
        }

        Double div = convertToDouble(numberOne) / convertToDouble(numberTwo);
        return div;
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null)
            return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number))
            return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null)
            return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
