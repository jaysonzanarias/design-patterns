package structural_patterns.decorator;

public interface DataSource {
    void writeData(String data);
    String readData();
}
