package Util.error;

import Util.position;

public class irError extends error{
    public irError(String msg, position pos){
        super("IR Error: " + msg, pos);
    }
}
