package Easy.num1114;

import java.util.concurrent.atomic.AtomicInteger;

public class Foo {
  private AtomicInteger count;

  public Foo() {
    count = new AtomicInteger(0);
  }

  public void first(Runnable printFirst) throws InterruptedException {
    while (count.get() != 0);
    // printFirst.run() outputs "first". Do not change or remove this line.
    printFirst.run();
    count.incrementAndGet();
  }

  public void second(Runnable printSecond) throws InterruptedException {
    while (count.get() != 1);
    // printSecond.run() outputs "second". Do not change or remove this line.
    printSecond.run();
    count.incrementAndGet();
  }

  public void third(Runnable printThird) throws InterruptedException {
    while (count.get() != 2);
    // printThird.run() outputs "third". Do not change or remove this line.
    printThird.run();
    count.incrementAndGet();
  }
}