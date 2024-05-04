import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserialize implements Serializable {

    private static final long serialVersionUID = 1L;

    String name;
    String address;
    int mobileNum;

    public SerializeAndDeserialize(String name, String address, int mobileNum) {
        this.name = name;
        this.address = address;
        this.mobileNum = mobileNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(int mobileNum) {
        this.mobileNum = mobileNum;
    }

    @Override
    public String toString() {
        return "SerializeAndDeserialize [name=" + name + ", address=" + address + ", mobileNum=" + mobileNum + "]";
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        SerializeAndDeserialize serializeAndDeserialize1 = new SerializeAndDeserialize("Aks1", "301", 1234567890);
        SerializeAndDeserialize serializeAndDeserialize2 = new SerializeAndDeserialize("Aks2", "302", 1234567891);
        SerializeAndDeserialize serializeAndDeserialize3 = new SerializeAndDeserialize("Aks3", "303", 1234567892);

        System.out.println("Using ObjectOutputStream and ObjectInputStream");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("objects.txt"));
        out.writeObject(serializeAndDeserialize1);
        out.writeObject(serializeAndDeserialize2);
        out.writeObject(serializeAndDeserialize3);
        out.close();

        ObjectInputStream input = new ObjectInputStream(new FileInputStream("Objects.txt"));
        List<SerializeAndDeserialize> list = new ArrayList<>();
        while(true) {
            try {
                SerializeAndDeserialize serializeAndDeserialize = (SerializeAndDeserialize) input.readObject();
                System.out.println(serializeAndDeserialize);
                list.add(serializeAndDeserialize);
            }
            catch(Exception e) {
                break;
            }
        }
        input.close();

        System.out.println("--------------------------------------------------");
        System.out.println("Using FileReader and FileWriter");

        FileWriter fileWriter = new FileWriter("readerWriter.txt");
        for(SerializeAndDeserialize sd : list)
            fileWriter.write(sd.toString()+"\n");
        fileWriter.close();

        FileReader fileReader = new FileReader("readerWriter.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        while((line=reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

} 