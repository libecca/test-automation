package FlowerShop;

public interface FlowerVisitor {
    public double calculate(Rose rose);
    public double calculate(IndianLotus indianLotus);
    public double calculate(Jasmine jasmine);
    public double calculate(Marigold marigold);
    public double calculate(SunFlower sunFlower);
}
