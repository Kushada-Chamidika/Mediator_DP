package designpatterns02day08mediator;

/**
 *
 * @author 1999k
 */
public class Test {

    public static void main(String[] args) {

        A a = new A();
        B b = new B();
        C c = new C();

//        a.setB(b);
//        a.setC(c);
//
//        b.setA(a);
//        b.setC(c);
//
//        c.setA(a);
//        c.setB(b);
//        a.q();
//        b.w();
//        c.e();
        Mediator mediator = new Mediator(a, b, c);

        a.setMediator(mediator);
        b.setMediator(mediator);
        c.setMediator(mediator);

        a.q();
        b.w();
        c.e();

    }

}

class Mediator {

    private final A a;
    private final B b;
    private final C c;

    public Mediator(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void callAq() {
        a.q();
    }

    public void callBw() {
        b.w();
    }

    public void callCe() {
        c.e();
    }

}

abstract class Component {

    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

}

class A extends Component{

//    public A(Mediator mediator) {
//        this.mediator = mediator;
//    }
//    B b;
//    C c;
//    public A(B b, C c) {
//        this.b = b;
//        this.c = c;
//    }
//    public void setB(B b) {
//        this.b = b;
//    }
//
//    public void setC(C c) {
//        this.c = c;
//    }
    public void q() {
        System.out.println("A - q");
        mediator.callBw();
        mediator.callCe();
//        b.w();
//        c.e();
    }

}

class B extends Component {

//    Mediator mediator;

//    public B(Mediator mediator) {
//        this.mediator = mediator;
//    }
//    public void setMediator(Mediator mediator) {
//        this.mediator = mediator;
//    }

//    A a;
//    C c;
//    public B(A a, C c) {
//        this.a = a;
//        this.c = c;
//    }
//    public void setA(A a) {
//        this.a = a;
//    }
//
//    public void setC(C c) {
//        this.c = c;
//    }
    public void w() {
        System.out.println("B - w");
        mediator.callCe();
//        a.q();
//        c.e();
    }

}

class C extends Component {

//    Mediator mediator;

//    public C(Mediator mediator) {
//        this.mediator = mediator;
//    }
//    public void setMediator(Mediator mediator) {
//        this.mediator = mediator;
//    }

//    A a;
//    B b;
//    public C(A a, B b) {
//        this.a = a;
//        this.b = b;
//    }
//    public void setA(A a) {
//        this.a = a;
//    }
//
//    public void setB(B b) {
//        this.b = b;
//    }
    public void e() {
        System.out.println("C - e");
        mediator.callAq();
        mediator.callBw();
//        a.q();
//        b.w();
    }

}
