package RISCV32.Oprand;

public class PhyReg extends Reg{
    public final String name;
    private boolean busy;
    public PhyReg(String _name) {
        super();
        name = _name;
        busy = false;
    }
    public void occupy() {
        if (busy) throw new RuntimeException("register occupation error: "+name);
        busy = true;
    }
    public void free() {
        if (!busy) throw new RuntimeException("register occupation error: "+name);
        busy = false;
    }
    public boolean isBusy() { return busy; }
    @Override public String toString() {return name;}
}
