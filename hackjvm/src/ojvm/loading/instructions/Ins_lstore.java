package ojvm.loading.instructions;
                         
import ojvm.loading.ClassFileInputStreamE;

import ojvm.data.JavaException;
import ojvm.operations.InstructionVisitor;

import ojvm.util.RuntimeConstants;

/**
 * The encapsulation of an lstore instruction. 
 * @author Amr Sabry
 * @version jdk-1.1
 */

public class Ins_lstore extends Instruction {
  private int index;

  public Ins_lstore (InstructionInputStream classFile) throws ClassFileInputStreamE {
      super(RuntimeConstants.opc_lstore);
      this.index = classFile.readU1();
  }

  protected Ins_lstore (int opcode, int index) {
    super(opcode);
    this.index = index;
  }

  public int getIndex () { return index; }

  public void accept (InstructionVisitor iv) throws JavaException {
    iv.visit_lstore (this);
  }

  public String toString () {
    return opcodeName + " " + index; 
  }
}
