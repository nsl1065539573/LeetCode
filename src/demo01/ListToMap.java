package demo01;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ListToMap {
  public static void main(String[] args) {
    ListToMap list = new ListToMap();
    List<Pojo> pojos = new LinkedList<>();
    pojos.add(new Pojo(1, "Tom"));
    pojos.add(new Pojo(2, "Jerry"));
    pojos.add(new Pojo(3, "Mike"));
    pojos.add(new Pojo(4, "XiaoMing"));
    HashMap<Integer, Pojo> map = new HashMap<>();
    pojos.forEach(pojo -> map.put(pojo.id, pojo));
    pojos.forEach(pojo -> {
      if (pojo.id == 3) {
        pojo.name = "Jack";
      }
    });
    System.out.println(map);
  }
}


class Pojo {
  Integer id;
  String name;

  public Pojo(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public String toString() {
    return "Pojo{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}