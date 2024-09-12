import java.util.Arrays;

public class Data {
    private String[] header;
    private int[][] data;

    public Data() {
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return  Arrays.toString(header) +
                "\n" + Arrays.deepToString(data);
    }
}

