
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class TxRx {

	public static void main(String[] args) throws Exception {
		
		RandomAccessFile memoryMappedFile = new RandomAccessFile("largeFile.txt", "rw");

        //Mapping a file into memory
		int count = 80;
		
        MappedByteBuffer mmf = memoryMappedFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, count);

        //Writing into Memory Mapped File
        for (int i = 0; i < count; i++) {
        	mmf.put((byte) 'A');
        }

        System.out.println("Writing to Memory Mapped File is completed");

     

        //reading from memory file in Java
        for (int i = 0; i < count ; i++) {
            System.out.print((char) mmf.get(i));
        }

        System.out.println("\nReading from Memory Mapped File is completed");
        
        memoryMappedFile.close();
	}

}
