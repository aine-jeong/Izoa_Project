import kr.or.Izoa.*;

public class IzoaSalon_main {
    public static void main(String[] args) {
        Member m = new Member();
        Manager mg = new Manager();

        mg.load_Review();
        mg.exit_System();
    }
}
