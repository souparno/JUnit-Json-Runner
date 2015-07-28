package myclass;


class MyClass {

  public int add(int a, int b) {
    return a+b;
  }

  public static void main (String args[]) {
    MyClass instance = new MyClass();
    System.out.println(instance.add(2,3));
  }

}
