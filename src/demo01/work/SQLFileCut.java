package demo01.work;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SQLFileCut {
  public static void main(String[] args) {
    String path = "/Users/nansongling/Library/Containers/com.tencent.WeWorkMac/Data/Library/Application Support/WXWork/Data/1688850082181014/Cache/File/2021-02";
    String name = "result";
    File file = new File(path + "/" + name);
    int lineIndex = 0;
    BufferedReader bufferedReader = null;
    try {
      bufferedReader = new BufferedReader(new FileReader(file));
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        String newFileName = name + "-" + lineIndex / 5000;
        File newFile = new File(path + "/" + newFileName);
        if (!newFile.exists()) {
          newFile.createNewFile();
        }
        FileWriter writer = new FileWriter(newFile, true);
        writer.write(line + ",");
        writer.close();
        lineIndex += 1;
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (bufferedReader != null) {
          bufferedReader.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
